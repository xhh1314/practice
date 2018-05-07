package practice.algorithm.other;

/**
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
 *
 * @author lihao
 * @version 1.0
 * @date 2018/5/7
 */
public class MergeSortedLinked {


    public static Node sort(Node A, Node B) {
        Node headA = A;
        Node headB = B;
        Node result = null;
        Node index = null;
        if (A.compareTo(B) > 0) {
            index = B;
            headB = B.next;
        } else {
            index = A;
            headA = A.next;
        }
        result = index;
        while (headA != null && headB != null) {
            if (headA.compareTo(headB) < 0) {
                index.next = headA;
                headA = headA.next;
            } else {
                index.next = headB;
                headB = headB.next;
            }
            index = index.next;
        }
        if (headA != null) {
            index.next = headA;
        }
        if (headB != null) {
            index.next = headB;

        }

        return result;

    }


    private static class Node implements Comparable<Node> {
        int value;
        Node next;

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }


}


/*
* 解题思路：使用4个辅助指针进行移动，原理类似于归并排序中两个有序数组排序
* */
