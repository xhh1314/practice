package practice.algorithm.other;

import practice.linked.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author lh
 * @date 2018/6/18
 */
public class AddTwoNumber {


    private ListNode reverseNode(ListNode root) {
        ListNode current = root;
        ListNode next = root.next;
        ListNode temp = null;
        current.next = temp;
        while (current != null && next != null) {
            temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        return current;
    }

    private int transferLinkedToInteger(ListNode root) {
        if (root.val == null)
            return 0;
        int max = Integer.MAX_VALUE;
        int result = 0;
        int maxTemp = max / 10;
        while (root != null) {
            if (result > maxTemp)
                return 0;
            if (result * 10 > max - root.val)
                return 0;
            result = result * 10 + root.val;
            root = root.next;
        }
        return result;
    }

    private ListNode transferIntegerToLinked(int n) {
        int value = 0;
        ListNode root = new ListNode();
        while (n >= 1) {
            value = n % 10;
            addNode(root, value);
            n = n / 10;
        }
        return root;
    }

    private void addNode(ListNode root, int value) {
        if (root.val == null) {
            root.val = value;
            return;
        }
        while (root.next != null) {
            root = root.next;
        }
        root.next = new ListNode();
        root.next.val = value;
    }

    public ListNode getResult(ListNode l1, ListNode l2) {
        int numberA = transferLinkedToInteger(reverseNode(l1));
        int numberB = transferLinkedToInteger(reverseNode(l2));
        int result = numberA + numberB;
        ListNode r = transferIntegerToLinked(result);
        return r;
    }


    public static void main(String[] args) {
        AddTwoNumber instance = new AddTwoNumber();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(instance.reverseNode(n1));
        int a = instance.transferLinkedToInteger(n5);
        System.out.println(a);
        ListNode node = instance.transferIntegerToLinked(a);
        System.out.println(node);
    }


//------------------------直接进行加减的做法------------------------
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode result;

        while (l1!=null && l2!=null){
            //int n=l1.val


        }

        return null;
    }
}
/*
* 常规思路：反转链表，再转换成整数，再求和，再转换成链表，这种方法能实现，但是代码量很大。
*
* 求巧思路：直接对每位数使用加法运算
*
* */