package practice.algorithm.other;

/**
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 * 例如输入一个长度为 9 的数组｛ 1, 2, 3, 2, 2, 2, 5, 4, 2｝。
 * 由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2 。题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 * 例如输入一个长度为 9 的数组｛ 1, 2, 3, 2, 2, 2, 5, 4, 2｝。
 * 由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2 。
 *
 * @author lh
 * @date 2018/5/4
 * @since
 */
public class MoreThanHalfOfArray {


    public static int findNumber(int[] target) {
        if (target == null)
            return 0;
        if (target.length == 1)
            return target[0];
        int result = target[0];
        int time = 1;
        for (int i = 1; i < target.length; i++) {
            if (result == target[i]) {
                time++;
            } else {
                time--;
                if (time == 0) {
                    result = target[i];
                    time++;
                }
            }

        }
        if (time <= 1)
            return 0;
        return result;


    }

    public static void main(String[] args) {
        int[] target = {1, 2, 3, 1, 1,2, 1, 4, 1,2};
        System.out.println(findNumber(target));
    }


}

