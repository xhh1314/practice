package practice.algorithm.other;

/**
 * 反转一个链表
 *
 * @author lh
 * @date 2018/4/26
 * @since
 */
public class ReverseLink {


    public static void reverseLink(Node root, Node parent) {
        if (root == null)
            return;
        if (root.next != null)
            reverseLink(root.next, root);
        root.next = parent;
    }


    public static void main(String[] args) {
        Node a = new Node(1, null);
        Node b = new Node(2, a);
        Node c = new Node(3, b);
        Node d = new Node(4, c);
        reverseLink(d, null);
        Node temp = a;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }


    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
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
* 解题思路：
* 1、递归实现
* 2、使用栈来实现
* */