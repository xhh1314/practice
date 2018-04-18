package practice.tree;

public  class TreeNode <T extends Comparable<T>>{
	
	public TreeNode <T> left;
	public TreeNode <T> right;
	public T element;
	
	/**
	 *二叉平衡树需要这个属性 
	 */
	public int height;
	public TreeNode(T e){
		this(e,null,null);
	}
	public TreeNode(T e,TreeNode<T> left,TreeNode<T> right){
		this.element=e;
		this.left=left;
		this.right=right;
		this.height=0;
		
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("TreeNode{");
		sb.append("element=").append(element);
		sb.append('}');
		return sb.toString();
	}
}
