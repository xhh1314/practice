package practice.tree;

import java.util.Random;
import java.util.Stack;

public class BinarySearchTree {
	public static void main(String[] args){
		BinaryTree1<Integer> t=new BinaryTree1<Integer>();
		Random rand=new Random();
		for(int i=0;i<20;i++){
			t.add(rand.nextInt(1000));
		}
		t.preOrderPrint(t);
		
	
	}
	

}

class BinaryTree1<T extends Comparable<? super T>>{
	T value;
	BinaryTree1<T> left;
	BinaryTree1<T> right;
	
	public BinaryTree1(){}
	public BinaryTree1(T value){
		this.value=value;
		this.left=null;
		this.right=null;
	}
	public void add(T v){
		insert(this,v);
		
	}
	
	//递归版
	public void insert(BinaryTree1<T> tree,T v){
		if(tree.value==null){
			tree.value=v;
			return;
		}
		int p=v.compareTo(tree.value);
		if(p<0){
			BinaryTree1<T> l;
			if((l=tree.left)!=null)
				insert(l,v);
			else
				tree.left=new BinaryTree1<T>(v);
		}
		else if(p>0){
			BinaryTree1<T> r;
			if((r=tree.right)!=null)
				insert(r,v);
			else
				tree.right=new BinaryTree1<T>(v);
		}
		else
			return;	
	}
	

	//迭代版
	public void insertV2(BinaryTree1<T> t,T v){
		if(t.value==null){
			t.value=v;
			return;
		}
		BinaryTree1<T> tree=t;
		while(tree!=null){
			int p=v.compareTo(tree.value);
			if(p<0){
				BinaryTree1<T> l;
				if((l=tree.left)!=null){
					tree=l;
					continue;
				}
				else{
					tree.left=new BinaryTree1<T>(v);
					break;
				}
			}
			else if(p>0){
				BinaryTree1<T> r;
				if((r=tree.right)!=null){
					tree=r;
					continue;
				}
				else{
					tree.right=new BinaryTree1<T>(v);
					break;
				}
			}
			else
				return;	
			
		}
		
	}
	//先序遍历
	public void preOrderPrint(BinaryTree1<T> root){
		Stack<BinaryTree1<T>> stack=new Stack<BinaryTree1<T>>();
		while(root!=null || !stack.empty()){
			if(root!=null){
				System.out.println(root.value);
				stack.push(root);
				root=root.left;
			}
			else{
				root=stack.pop();
				root=root.right;
				
			}
			
			
		}
		
	}
	
	
	
	

	void inorderPrint(BinaryTree1<T> root){
		if(root!=null){
			inorderPrint(root.left);
			System.out.println(root.value);
			inorderPrint(root.right);
			
		}
		
	}

   void postPrint(BinaryTree1<T> root){
	   Stack<BinaryTree1<T>> stack=new Stack<BinaryTree1<T>>();
	 
	   
	   
   }
	
	
	
}