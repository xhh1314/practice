package practice.algorithm.other;

/**
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为 O(n)。
 *
 * @author lh
 * @date 2018/5/15
 * @since
 */
public class SequentialSubarrayMaxSum {

    public static int findMaXSum(int[] array) {
        int cur = 0;
        int result = cur;

        for (int i = 0; i < array.length; i++) {
            cur = cur + array[i];
            if (cur < 0)
                cur = 0;
            result = Math.max(result, cur);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = {5, 1, 2, -1, -3, 4};
        System.out.println(findMaXSum(a));
    }

}
/*
* 解题思路：
* 数组有正负数这个条件是关键,所以只要每一个前缀值小于0就不是最大值，叠加过程中丢弃掉求和是负数的情况
* */
