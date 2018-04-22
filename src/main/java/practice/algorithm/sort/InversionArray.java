package practice.algorithm.sort;

/**
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * 例如在数组｛7, 5, 6, 4}中，
 * 一共存在 5 个逆序对，分别是（7, 6）、（7，5），(7, 4）、（6, 4）和（5, 4）。
 *
 * @author lh
 * @date 2018/4/20
 * @since
 */
public class InversionArray {


    public int inversionCount(int[] target, int[] temp, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            int leftCount = inversionCount(target, temp, left, middle);
            int rightCount = inversionCount(target, temp, middle + 1, right);
            int mergeCount = merge(target, temp, left, right);
            return leftCount + rightCount + mergeCount;
        }
        return 0;
    }


    private int merge(int[] target, int[] temp, int left, int right) {
        if (left == right)
            return 0;
        int m = (left + right) / 2;

        int l = left;
        int r = m + 1;
        int i = left;
        //先进行排序
        while (l <= m && r <= right) {
            if (target[l] >= target[r]) {
                temp[i++] = target[l++];
            } else {
                temp[i++] = target[r++];
            }
        }
        while (l <= m) {
            temp[i++] = target[l++];
        }
        while (r <= right) {
            temp[i++] = target[r++];
        }
        //计算逆序对个数
        int leftEnd = m;
        while (leftEnd >= left && target[leftEnd] < target[m + 1]) {
            leftEnd--;
        }
        int count = (leftEnd - left + 1) * (right - (m + 1) + 1);

        //最后把temp里有序数复制过来
        while (left <= right) {
            //这里注意会犯一个错误,错误写法: target[left++] = temp[left++];
            target[left] = temp[left++];
        }

        return count;

    }

    public static void main(String[] args) {
        int[] target = {7, 5, 6, 4, 3};
        int[] temp = new int[target.length];
        InversionArray inversionArray = new InversionArray();
        int count = inversionArray.inversionCount(target, temp, 0, target.length - 1);
        System.out.println("逆序对数量:" + count);
    }
}

/*
* 解题思路：利用归并排序思路来实现,先假设左右两边数组有序，并且是递减，这样找到左边第一个大于右边的数，那么就能算出有多少个逆序对，采用分冶思想求解
* */