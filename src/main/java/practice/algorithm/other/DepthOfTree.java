package practice.algorithm.other;

import practice.tree.TreeNode;

/**
 * 求一颗二叉树的深度
 *
 * @author lihao
 * @version 1.0
 * @date 2018/5/6
 */
public class DepthOfTree {


    public static int calculateDepth(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        int left = calculateDepth(root.left);
        int right = calculateDepth(root.right);
        return left >= right ? left + 1 : right + 1;

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
        System.out.println(calculateDepth(root));
    }


}
/*
* 直接递归计算左右树的高度即可
* */