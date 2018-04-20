package practice.linked;

/**
 * 反转链表实现
 *
 * @author lh
 * @date 2018/2/26
 * @since
 */
public class ReverseLinkDemo<T> {
    ListNode<T> head;


    public void reverse(){
        if(this.head==null)
            return;
        ListNode<T> pre=null;
        ListNode<T> next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
    }


}

class ListNode<T>{
    T value;
    ListNode<T> next;

}
