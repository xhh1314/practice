package practice.tree;

import java.util.Stack;

/**
 * 构造一颗简单的数
 * @author lh
 * @date 2017年10月10日
 * @version 1.0
 */
public class NormalTree {
	public static void main(String[] args){
		Node<Integer> node=new Node<Integer>();
		node.add(1, null);
		node.add(2, 1);
		node.add(3, 1);
		node.add(4, 1);
		node.add(5, 2);
		node.add(6, 2);
		node.add(7, 2);
		node.add(8, 2);
		node.add(9, 4);
		node.add(10, 4);
		node.add(11, 7);
		node.add(12, 7);
	}

}

class Node<T>{
	private Node<T> root;//第一个节点
	private T value;
	private Node<T> fc;//fristChild
	private Node<T> next;
	public Node(){}
	private Node(T value){
		this.value=value;
	}
	/**
	 * @param value 待插入的值
	 * @param p 父节点的值
	 */
	public void add(T value,T p){
		if(root==null){
			root=new Node<T>(value);
			return;
		}
		Node<T> parent=findNode(p);
		if(parent==null){
			throw new RuntimeException("父节点不存在！");
		}
		Node<T> fristChild=parent.fc;
		if(fristChild==null){
			fristChild=new Node<T>(value);
			parent.fc=fristChild;
			return;
		}
		while(fristChild.next!=null){
			fristChild=fristChild.next;
		}
		fristChild.next=new Node<T>(value);
	}
	public  Node<T> findNode(T value){
		if(root==null)
			return null;
		Stack<Node<T>> stack=new Stack<Node<T>>();
		Node<T> temp=root;
		while(true){
			if(value.equals(temp.value) || value==temp.value){
				return temp;
			}else{
				Node<T> fristChild=null;
				if((fristChild=temp.fc)!=null){//看有么有子节点
					stack.push(temp);
					temp=fristChild;
				}else if(temp.next!=null){//再看有么有兄弟节点
					temp=temp.next;
				}
				else{
					if(stack.isEmpty())//已经没有子节点，栈已空，说明循环应该到此结束！
						return null;
					temp=stack.pop().next;
				}
			}
		}
		
	}
	
	
}
