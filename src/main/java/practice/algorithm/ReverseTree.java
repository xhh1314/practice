package practice.algorithm;

import practice.tree.TreeNode;
import java.util.Stack;

/**
 * 反转二叉树
 */
public class ReverseTree<T extends Comparable<T>> {


    /**
     * 采用先遍历反转
     * todo 先序遍历非递归版是无法实现反转的
     *
     * @param root
     */
    @Deprecated
    public void reverseTreeIterator1(TreeNode<T> root) {

        TreeNode<T> temp = root;
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> changeTemp;
        while (temp != null || !stack.isEmpty()) {
            //先进行交换，才行
            if (temp != null) {
                changeTemp = temp.left;
                temp.left = temp.right;
                temp.right = changeTemp;
            }
            if (temp.left != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop().right;
            }

        }


    }

    /**
     * 非递归版反转实现
     *
     * @param root
     */
    public void reverseTreeIterator(TreeNode<T> root) {
        if (root == null)
            return;
        TreeNode<T> temp = root;
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(temp);
        while (stack.size() > 0) {
            temp = stack.pop();
            TreeNode<T> changeTemp = temp.left;
            temp.left = temp.right;
            temp.right = changeTemp;
            if (temp.left != null)
                stack.push(temp.left);
            if (temp.right != null)
                stack.push(temp.right);
        }


    }


    /**
     * 应该用后续遍历反转才正确
     * 递归方式实现后序遍历 ，并反转二叉树
     *
     * @param root
     */
    public void recursionRevert(TreeNode<T> root) {

        if (root.left != null) {
            recursionRevert(root.left);
        }
        if (root.right != null) {
            recursionRevert(root.right);
        }
        if (root.left != null || root.right != null) {
            TreeNode<T> changeTemp;
            changeTemp = root.left;
            root.left = root.right;
            root.right = changeTemp;
        }
    }


    /**
     * 先序递归打印
     */
    public void printTree(TreeNode<T> root) {
        if (root != null) {
            System.out.println(root.element);
        }
        if (root.left != null) {
            printTree(root.left);
        }
        if (root.right != null) {
            printTree(root.right);
        }


    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(9);
        root.right = new TreeNode<Integer>(16);
        root.left.left = new TreeNode<Integer>(7);
        root.left.right = new TreeNode<Integer>(8);
        root.left.left.left = new TreeNode<Integer>(5);
        root.left.left.right = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(18);
        root.right.left = new TreeNode<Integer>(15);

        ReverseTree<Integer> reverseTree = new ReverseTree<>();
        reverseTree.reverseTreeIterator(root);
        reverseTree.printTree(root);
    }

}
