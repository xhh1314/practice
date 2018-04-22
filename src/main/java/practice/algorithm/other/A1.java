package practice.algorithm.other;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
 *
 * @author lh
 * @date 2018/4/22
 * @since
 */
public class A1 {
    public void exchange(int[] arr) {
        int p1 = -1, p2 = arr.length;
        while (p1 < p2) {
            //注意内循环也需要判断指针位置
            while (p1 < p2 && judge(arr[++p1])) ;
            while (p1 < p2 && !judge(arr[--p2])) ;
            int temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
        }
    }

    /**
     * 判断是否是偶数
     *
     * @param val
     * @return
     */
    private boolean judge(int val) {
        int result = val % 2;
        return result == 0;
    }

    public static void main(String[] args) {

        A1 a1 = new A1();
        int[] arr = {1, 2, 3, 5, 5, 5, 5, 4, 5, 6, 7};
        a1.exchange(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}



/*
* 解题思路：
* 第一种：插入排序思想，比较并交换，交换条件就是arr[i]是奇数,arr[i-1] 是偶数 时间复杂度n2 空间复杂度n
*
* 第二种: 使用双指针实现，p1=arr[0]， p2=arr[length-1] p1遇到偶数停，p2 遇到奇数停, 时间复杂度n
*
* 扩展：此种解题思路应对类似非负数放在前面、将所有能被3整除的数放在前面...的题都适用，把判断条件抽出来即可
* */