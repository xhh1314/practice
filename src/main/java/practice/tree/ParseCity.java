package practice.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解析编码格式的国家城市算法实现
 * <p>
 * 110000	北京市
 * 110100	市辖区
 * 110101	东城区
 * 110102	西城区
 * 110105	朝阳区
 * 110106	丰台区
 * 110107	石景山区
 * 110108	海淀区
 * 110109	门头沟区
 * 110111	房山区
 * 110112	通州区
 * 110113	顺义区
 * 110114	昌平区
 * 110115	大兴区
 * 110116	怀柔区
 * 110117	平谷区
 * 110200	县
 * 110228	密云县
 * 110229	延庆县
 * 120000	天津市
 * 120100	市辖区
 * 120101	和平区
 * 120102	河东区
 * 120103	河西区
 * 120104	南开区
 *
 * @author lh
 * @date 2018/2/4
 * @since
 */
public class ParseCity {

    private static final Logger log = LoggerFactory.getLogger("ParseCityService");

    private final Node root = new Node();
    /**
     * 编码的长度
     */
    private final int encodingLength;
    private final int totalLength;

    private final List<AppCity> cities;

    private String zeroPattern = "[1-9]+";


    public ParseCity(List<AppCity> cities, int encodingLength, int totalLength) {
        this.cities = cities;
        this.encodingLength = encodingLength;
        this.totalLength = totalLength;
    }

    private final Pattern pattern = Pattern.compile(zeroPattern);

    private final List<AppCity> failNode = new LinkedList<>();

    public void initial() {
        doInitial(this.cities);
    }

    private void doInitial(List<AppCity> cities) {
        if (this.totalLength % encodingLength != 0) {
            throw new IllegalArgumentException("不合法的编码格式!");
        }
        int num = totalLength / encodingLength;
        StringBuilder zeroCode = new StringBuilder();
        for (int i = 0; i < totalLength; i++) {
            zeroCode.append("0");
        }
        //得到全部是0的字符串
        String zeroString = zeroCode.toString();
        this.root.id = Integer.parseInt(zeroString);
        for (AppCity city : cities) {
            String code = city.getCityId().toString();
            //先判断下是否是根,即code=00000000的情况
            if (!pattern.matcher(code).find()) {
                this.root.name = city.getName();
                this.root.id = city.getCityId();
                continue;
            }
            int count = 1;
            while (count <= num) {
                String subCode = code.substring(count * encodingLength);
                Matcher matcher = pattern.matcher(subCode);
                if (!matcher.find()) {
                    if (count == 1) {
                        newNode(city, root);
                    } else {
                        String parentCode = code.substring(0, (count - 1) * encodingLength) + zeroString.substring((count - 1) * encodingLength);
                        Node parent = findNodeById(Integer.parseInt(parentCode));
                        if (parent == null) {
                            log.info("节点{}暂未找到父节点!", code);
                            AppCity city1 = new AppCity();
                            city1.setCityId(Integer.parseInt(parentCode));
                            if (!cities.contains(city1)) {
                                throw new IllegalArgumentException("父节点不存在!");
                            }
                            failNode.add(city);
                            break;
                        }
                        newNode(city, parent);
                    }
                    break;
                }
                count++;

            }


        }

        //如果有因为插入时父节点不存在的节点，则加入失败节点，然后重新再添加一次，主要是为了解决,错误的顺序导致的插入父节点失败问题！
        if (!failNode.isEmpty()) {
            doInitial(failNode);
        }


    }

    /**
     * 新增一个节点，更新node的next 和 parent属性
     *
     * @param city
     * @param parent
     * @return
     */
    private Node newNode(AppCity city, Node parent) {
        Node newNode = new Node(city.getCityId(), city.getName());
        newNode.parent = parent.id;
        if (parent.first == null) {
            parent.first = newNode;
        } else {
            Node next = parent.first;
            while (next.next != null) {
                next = next.next;
            }
            next.next = newNode;
        }
        return newNode;
    }

    /**
     * 广度优先遍历
     *
     * @param id
     * @return
     */
    public Node findNodeById(Integer id) {
        String code = id.toString();
        if (id == null || code.length() != totalLength)
            throw new IllegalArgumentException("不合法的id");
        Node next = this.root;
        //Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new ArrayDeque<>(50);
        while (next != null || !queue.isEmpty()) {
            if (next == null)
                next = queue.poll();
            if (next.id == id)
                return next;
            if (next.first != null)
                queue.add(next.first);
            next = next.next;
        }

        return null;
    }


    /**
     * 广度优先遍历，打印所有节点
     */
    public void print() {
        Node next = this.root;
        Queue<Node> queue = new ArrayDeque(50);
        while (next != null || !queue.isEmpty()) {
            if (next == null)
                next = queue.poll();
            if (next.first != null)
                queue.add(next.first);
            System.out.println("insert into app_city ('code','name','parent') values (" + "'" + next.id + "','" + next.name + "','" + next.parent + "');");
            next = next.next;
        }

    }


    private static class Node {
        private int id;
        private String name;
        private int parent;
        private Node next;
        private Node first;
        /**
         * 是否是叶子节点
         */
        private boolean leaf;

        Node() {
        }

        Node(Integer id, String name) {
            this.name = name;
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return id == node.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

}

class AppCity {

    private Integer cityId;
    private String Name;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "AppCity{" +
                "cityId=" + cityId +
                ", Name='" + Name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppCity appCity = (AppCity) o;

        return cityId.equals(appCity.cityId);
    }

    @Override
    public int hashCode() {
        return cityId.hashCode();
    }
}
