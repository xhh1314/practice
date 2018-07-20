package practice.algorithm.other;

/**
 * 判断两个单向链表是否相交
 * <p>
 * 这个demo 测试了其中可能的各种情况
 *
 * @author lh
 * @date 2018/6/11
 * @since
 */
public class EstimateCommonNodeOfLink {


    /**
     * 寻找一个单向链表的环入口节点
     *
     * @param head
     * @return null 表示没有环
     */
    private Node findLoopChain(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null)
            return null;

        fast = head;

        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;

    }


    /**
     * 两个单向链表都无环的情况下，寻找第一个公共节点
     *
     * @return
     */
    private Node findCommonNodeOfNoLoop(Node head1, Node head2) {

        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2)
            return null;
        //让cur1指向长度更长的链表
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n > 0) {
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;


    }


    public static void main(String[] args) {
        EstimateCommonNodeOfLink instance = new EstimateCommonNodeOfLink();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        //---------测试环入口-------
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        //环
        node7.next = node3;
        System.out.println("寻找有环单向链表的环入口节点:" + instance.findLoopChain(node1));

        //清空链表指针，方便下一个测试
        node7.next = null;

        //-----------测试两个无环的单向链表是否相交------------------
        Node head1 = node1;
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Node head2 = node10;
        head2.next = node9;
        node9.next = node8;
        //交点node5
        node8.next = node5;

        System.out.println("两无环的单向链表相交点:" + instance.findCommonNodeOfNoLoop(head1, head2));


    }


    private static class Node {
        int value;
        Node next;

        Node() {
        }

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("value=").append(value);
            sb.append('}');
            return sb.toString();
        }

    }


}
/*
* 思路一：把a链表插入b链表尾节点，如果相交，则形成环链，环链入口即是相交点
*
* */