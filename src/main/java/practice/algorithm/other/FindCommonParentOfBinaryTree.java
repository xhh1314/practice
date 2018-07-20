package practice.algorithm.other;

import practice.tree.TreeNode;

/**
 * 一棵二叉树中，找到两个节点的最近公共祖先
 *
 * @author lh
 * @date 2018/5/31
 * @since
 */
public class FindCommonParentOfBinaryTree {

    public TreeNode findParent(TreeNode root, TreeNode a, TreeNode b) {
        int[] flag = new int[2];
        TreeNode[] result = new TreeNode[1];
        postOrder(root, flag, a, b, result);
        return result[0];
    }

    private int postOrder(TreeNode root, int[] flag, TreeNode a, TreeNode b, TreeNode[] result) {
        int left = 0, right = 0;
        if (root.left != null)
            left = postOrder(root.left, flag, a, b, result);
        if (root.right != null)
            right = postOrder(root.right, flag, a, b, result);

        int temp = 0;
        if (root.element == a.element || root.element == b.element)
            temp = 1;
        temp += left + right;
        if (temp == 2) {
            result[0] = root;
            return 0;
        }
        return temp;
    }

    public static void main(String[] args) {
        FindCommonParentOfBinaryTree instance = new FindCommonParentOfBinaryTree();
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(9);
        root.right = new TreeNode<Integer>(16);
        root.left.left = new TreeNode<Integer>(7);
        root.left.right = new TreeNode<Integer>(8);
        root.left.left.left = new TreeNode<Integer>(5);
        root.left.left.right = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(18);
        root.right.left = new TreeNode<Integer>(15);
        System.out.println(instance.findParent(root, new TreeNode(5), new TreeNode(7)));
    }

}
