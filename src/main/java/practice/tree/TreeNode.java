package practice.tree;

public  class TreeNode <T extends Comparable<T>>{
	
	public TreeNode <T> left;
	public TreeNode <T> right;
	public T element;
	
	/**
	 *二叉平衡树需要这个属性 
	 */
	public int height;
	TreeNode(T e){
		this(e,null,null);
	}
	TreeNode(T e,TreeNode<T> left,TreeNode<T> right){
		this.element=e;
		this.left=left;
		this.right=right;
		this.height=0;
		
	}

}
