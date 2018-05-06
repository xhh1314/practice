package practice.algorithm.other;

/**
 * Problem: Design a service like TinyURL, a URL shortening service, a web service that provides short aliases for redirection of long URLs.
 *
 * @Author lh
 * @Date 2018-04-23
 */
public class TinyUrl {

    private final char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    /**
     * 10进制转62进制
     *
     * @param id
     * @return
     */
    public String convertLongToString(long id) {
        StringBuilder stringBuilder = new StringBuilder();
        while (id > 0) {
            stringBuilder.insert(0, map[(int) id % 62]);
            id = id / 62;
        }
        while (stringBuilder.length() < 6) {
            stringBuilder.insert(0, map[0]);
        }

        return stringBuilder.toString();
    }

    /**
     * 62 进制转10进制
     *
     * @param str
     * @return
     */
    public long convertBase62toLong(String str) {
        char[] chars = str.toCharArray();
        long id = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int w = chars.length - 1 - i;
            id = id + (long) Math.pow(62d, (double) w) * getDecimal(chars[i]);
        }

        return id;
    }


    /**
     * 62 进制转10进制的第二种实现思路
     *
     * @param str
     * @return
     */
    public long convertBase62toLong2(String str) {
        long n = 0;
        for (int i = 0; i < str.length(); i++) {
            n = n * 62 + getDecimal(str.charAt(i));
        }
        return n;
    }

    private int getDecimal(char val) {
        if (val >= 'a' && val <= 'z') {
            return val - 'a';
        }
        if (val >= 'A' && val <= 'Z') {
            return val - 'A' + 26;
        }
        if (val >= '0' && val <= '9') {
            return val - '0' + 52;
        }

        return 0;

    }

    public static void main(String[] args) {
        TinyUrl tinyUrl = new TinyUrl();
        String base62 = tinyUrl.convertLongToString(55523334);
        long id = tinyUrl.convertBase62toLong2(base62);
        System.out.println("转换之后的long为:" + id);

    }


}
/*
* 解决思路: 把10进制转换成62进制进行存储
* 其实就是把url存到数据库，得到唯一long类型id，然后把该id编码成62进制的字符，然后生成url
* 最后根据这个url的字符，再转码成long 类型的id，根据该id取出原始url
* */