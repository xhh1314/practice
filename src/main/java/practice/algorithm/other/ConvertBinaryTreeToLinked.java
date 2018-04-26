package practice.algorithm.other;

import practice.tree.TreeNode;

/**
 * 把一颗二叉搜索树转换成排序的双向链表
 *
 * @author lh
 * @date 2018/4/25
 * @since
 */
public class ConvertBinaryTreeToLinked<T extends Comparable<T>> {


    /**
     * 创建二叉搜索树
     *
     * @param root
     * @param value
     */
    public void createBinaryTree(TreeNode<T> root, T value) {

        if (root == null)
            throw new NullPointerException();
        TreeNode<T> temp = root;

        TreeNode<T> p = null;
        while (temp != null) {
            p = temp;
            if (value.compareTo(temp.element) >= 0) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }

        }
        if (value.compareTo(p.element) >= 0) {
            p.right = new TreeNode<T>(value);
        } else {
            p.left = new TreeNode<T>(value);
        }

    }

    public TreeNode<T> convert(TreeNode<T> root) {
        //这里需要在堆中开辟一个地址来存储head指针，以保证递归中，栈帧中的临时变量值不会丢失
        TreeNode<T>[] head = new TreeNode[1];
        convertToLinked(root, head);
        TreeNode<T> first = head[0];
        while (first != null && first.left != null) {
            first = first.left;
        }
        return first;
    }

    private void convertToLinked(TreeNode<T> root, TreeNode<T>[] head) {
        if (root == null)
            return;
        if (root.left != null)
            convertToLinked(root.left, head);

        root.left = head[0];
        if (head[0] != null)
            head[0].right = root;
        head[0] = root;

        if (root.right != null)
            convertToLinked(root.right, head);

    }


    public static void main(String[] args) {
        ConvertBinaryTreeToLinked<Integer> instance = new ConvertBinaryTreeToLinked<>();
        TreeNode<Integer> root = new TreeNode<Integer>(9);
        //初始化链表
        instance.createBinaryTree(root, 20);
        instance.createBinaryTree(root, 18);
        instance.createBinaryTree(root, 21);
        instance.createBinaryTree(root, 17);
        instance.createBinaryTree(root, 19);
        instance.createBinaryTree(root, 5);
        TreeNode<Integer> first = instance.convert(root);


    }

}
/*
* 二叉排序树 中序遍历 其实就是一个排序的二叉树
* 解决方法一：低端办法，先中序遍历成一个有序数组，再构建双向链表
* 解决办法二：使用递归实现，这种办法需要深刻理解中序遍历过程及head指针含义
* */