package practice.tree;

import java.util.Stack;

/**
 * 平衡二叉查找树
 * 关键步骤：
 * 1、递归动态计算出各个子节点的height
 * 2、四种情况的旋转：左左：右旋转 右右：左旋转  左右：左子节点左旋转，根节点再右旋转    右左：右子节点右旋转，再根节点左旋转
 * 3、递归过程中传递调整后的节点
 * @author lh
 * @date 2017年10月18日
 * @version 
 * @param <T>
 */
public class MyAvlTree<T extends Comparable<T>> extends AbstractTree<T> {

	private static final int DIFFERENCE = 1;
	private TreeNode<T> root;

	public boolean insert(T value) {
		this.root=insertValue(value, this.root);
		return root!= null ? true : false;
	}

	@Override
	public boolean search(T value) {
		// TODO Auto-generated method stub
		return preOrderPrint(this.root, value);
	}

	private TreeNode<T> insertValue(T val, TreeNode<T> root) {
		if (root == null) {
			root = newNode(val);
			return root;
		}
		if (val.compareTo(root.element) < 0) {
			root.left = insertValue(val, root.left);
		} else if (val.compareTo(root.element) > 0) {
			root.right = insertValue(val, root.right);
		} else {
			root.element = val;
		}
		root = balance(root);

		return root;
	}

	/**
	 * 调整数节点，使其平衡
	 * 
	 * @param root
	 * @return
	 */
	private TreeNode<T> balance(TreeNode<T> root) {
		// TODO Auto-generated method stub
		if ((height(root.left) - height(root.right)) > DIFFERENCE) {
			// 左外插入
			if (height(root.left.left) > height(root.left.right))
				root = rotateRight(root);
			// 左内插入
			else {
				root.left = rotateLeft(root.left);
				root = rotateRight(root);
			}
		} else if ((height(root.right) - height(root.left)) > DIFFERENCE) {
			// 右内插入
			if (height(root.right.left) > height(root.right.right)){
				root.right = rotateRight(root.right);
				root = rotateLeft(root);
			}
				
			// 右外插入
			else {
				root = rotateLeft(root);
				
			}
		}
		root.height = max(height(root.left), height(root.right)) + 1;
		return root;
	}

	/**
	 * 空节点高度为-1，末级节点高度为0，这个理论在比较高度差的时候很重要
	 * 
	 * @param node
	 * @return
	 */
	private int height(TreeNode<T> node) {
		return node == null ? -1 : node.height;
	}

	private int max(int height, int height2) {
		// TODO Auto-generated method stub
		if (height == height2)
			return height;
		return height > height2 ? height : height2;
	}

	/**
	 * 左旋转
	 * 
	 * @param left
	 * @return
	 */
	private TreeNode<T> rotateLeft(TreeNode<T> root) {
		// TODO Auto-generated method stub
		TreeNode<T> right = root.right;
		root.right = right.left;
		right.left = root;
		// 左旋转之后，root节点被向左旋转，高度发生改变，重新计算
		root.height = max(height(root.left), height(root.right)) + 1;
		// 重新计算完right左节点高度（即新的root节点左节点）后,再计算根节点高度
		right.height = max(height(right.left), height(right.right)) + 1;
		return right;
	}

	/**
	 * 右旋转
	 * 
	 * @param root2
	 * @return
	 */
	private TreeNode<T> rotateRight(TreeNode<T> root) {
		// TODO Auto-generated method stub
		TreeNode<T> left = root.left;
		root.left = left.right;
		left.right = root;
		// 重新计算高度，原理同左旋转
		root.height = max(height(root.left), height(root.right)) + 1;
		left.height = max(height(left.left), height(left.right)) + 1;
		return left;
	}

	private TreeNode<T> newNode(T v) {
		return new TreeNode<T>(v);
	}

	@SuppressWarnings("unused")
	// 先序遍历 查找元素是否存在
	private boolean preOrderPrint(TreeNode<T> root, T value) {
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		while (root != null || !stack.empty()) {
			if (root != null) {
				if (root.element.equals(value) || root.element == value)
					return true;
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				root = root.right;

			}

		}
		return false;

	}

	@Override
	boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode<T> getRoot() {
		// TODO Auto-generated method stub
		return this.root;
	}

}
