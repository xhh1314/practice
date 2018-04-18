package practice.linked;

import java.util.ArrayList;

/**
 * 从尾到头打印链表
 * <p>
 * 使用递归方式实现,这里就不写打印的代码了
 *
 * @Author
 * @Date 2018-02-26
 */
public class PrintLinkedReverse {

    ArrayList<String> lists = new ArrayList<String>();

    public void addNodeToLinked(Node head) {
        if (head != null) {
            addNodeToLinked(head.next);
            lists.add(head.value);
        }

    }


    private class Node {
        private Node next;
        private String value;
    }
}
