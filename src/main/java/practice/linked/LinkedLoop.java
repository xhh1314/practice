package practice.linked;

/**
 * @Author
 * @Date 2018-02-26
 * <p>
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * <p>
 * 链接：https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4?orderByHotValue=1&mutiTagIds=580&page=1&onlyReference=false
 * 假设x为环前面的路程（黑色路程），a为环入口到相遇点的路程（蓝色路程，假设顺时针走）， c为环的长度（蓝色+橙色路程）
 * 当快慢指针相遇的时候：
 * 此时慢指针走的路程为Sslow = x + m * c + a
 * 快指针走的路程为Sfast = x + n * c + a
 * 2 Sslow = Sfast
 * 2 * ( x + m*c + a ) = (x + n *c + a)
 * 从而可以推导出：
 * x = (n - 2 * m )*c - a
 * = (n - 2 *m -1 )*c + c - a
 * 即环前面的路程 = 数个环的长度（为可能为0） + c - a
 * 什么是c - a？这是相遇点后，环后面部分的路程。（橙色路程）
 * 所以，我们可以让一个指针从起点A开始走，让一个指针从相遇点B开始继续往后走，
 * 2个指针速度一样，那么，当从原点的指针走到环入口点的时候（此时刚好走了x）
 * 从相遇点开始走的那个指针也一定刚好到达环入口点。
 * 所以2者会相遇，且恰好相遇在环的入口点。
 * 最后，判断是否有环，且找环的算法复杂度为：
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

public class LinkedLoop {

    //寻找环中的交叉点
    public Node findCrunode(Node node) {
        Node p1 = node.next;
        //防止npe
        if (p1 == null)
            return null;
        Node p2 = node.next.next;
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return null;
    }

    //寻找入口结点
    public Node findEntranceNode(Node node) {
        Node crunode = findCrunode(node);
        Node p1 = node, p2 = crunode;
        while (p1 != null && p2 != null) {
            if (p1 == p2)
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;

    }


    private class Node {
        Node next;
        String value;
    }
}

