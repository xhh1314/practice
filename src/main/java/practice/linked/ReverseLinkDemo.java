package practice.linked;

/**
 * 反转链表实现
 *
 * @author lh
 * @date 2018/2/26
 * @since
 */
public class ReverseLinkDemo<T> {
    Node<T> head;


    public void reverse(){
        if(this.head==null)
            return;
        Node<T> pre=null;
        Node<T> next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
    }


}

class Node<T>{
    T value;
    Node<T> next;

}
