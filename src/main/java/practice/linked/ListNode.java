package practice.linked;

public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(){}

    @Override
    public String toString() {
        return "node:" + val;
    }
}
