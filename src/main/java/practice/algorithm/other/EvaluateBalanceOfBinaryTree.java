package practice.algorithm.other;

import practice.tree.TreeNode;

/**
 * 输入根节点，判断该树是否是平衡的二叉树
 *
 * @author lh
 * @date 2018/5/30
 * @since
 */
public class EvaluateBalanceOfBinaryTree {

    public boolean evaluate(TreeNode root) {
        int[] flag = new int[1];
        calculateDepth(root, flag);
        return flag[0] == 0;
    }

    private int calculateDepth(TreeNode root, int[] flag) {
        if (root == null)
            return 0;
        int left = calculateDepth(root.left, flag);
        int right = calculateDepth(root.right, flag);
        if (Math.abs(left - right) >= 2)
            flag[0] = 1;
        return left >= right ? left+1 : right+1;
    }

    public static void main(String[] args) {
        EvaluateBalanceOfBinaryTree instance=new EvaluateBalanceOfBinaryTree();
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(9);
        root.right = new TreeNode<Integer>(16);
        root.left.left = new TreeNode<Integer>(7);
        root.left.right = new TreeNode<Integer>(8);
        root.left.left.left = new TreeNode<Integer>(5);
        root.left.left.right = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(18);
        root.right.left = new TreeNode<Integer>(15);
        System.out.println("是否平衡:"+instance.evaluate(root));
        root.left.left.left.left=new TreeNode<Integer>(4);
        System.out.println("是否平衡:"+instance.evaluate(root));
    }
}
