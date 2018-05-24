package practice.algorithm.other;

/**
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次，请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是 O(n)，空间复杂度是 O(1)。
 * 例如输入数组｛2, 4, 3, 6, 3, 2, 5 }，
 * 因为只有 4 、6 这两个数字只出现一次，其他数字都出现了两次，
 * 所以输出 4 和 6 。
 *
 * @author lh
 * @date 2018/5/24
 * @since
 */
public class FindTwoNumberOfOnce {


    /**
     * 找到只出现1次的两个数字
     *
     * @param target
     * @return
     */
    public int[] findTwoNumber(int[] target) {
        if (target == null || target.length < 2)
            return null;
        int i = 1, temp = target[0];
        while (i < target.length) {
            temp ^= target[i++];
        }
        int indexOf1 = findFirstBit1(temp);

        int[] result = new int[2];
        for (int j = 0; j < target.length; j++) {
            if (isFirstBit(target[j], indexOf1)) {
                //0异或任何数是其本身
                result[0] ^= target[j];
            } else {
                result[1] ^= target[j];
            }

        }
        return result;
    }


    private boolean isFirstBit(int a, int index) {
        return ((a >> index) & 1) == 1;
    }

    private int findFirstBit1(int a) {
        int index = 0;
        while ((a & 1) == 0 && index < 32) {
            a = a >> 1;
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        FindTwoNumberOfOnce instance = new FindTwoNumberOfOnce();
        int[] target = {2, 3, 11, 2, 11, 5, 22, 22};
        int[] result = instance.findTwoNumber(target);
    }
}
/*
解题思路：
* 1. 假如数组中只有1个数字只出现过一次，其他的都出现了两次，怎么找到它？
 *      我们可以用异或，因为异或：相同为0，不同为1
 *      所以我们可以从头到尾依次异或数组中的每一个数字，最终的异或结果刚好是只出现一次的那个数字。（那些成对出现的两个数字刚好在异或中抵消了）
 * 2. 那数组中又两个只出现一次的数字呢？
 *      我们可以把大数组分成两个子数组啊，每个子数组中都只有1个只出现一次的数字。
 *      这样分：
 *          - 还是从头到位依次异或数组中的每一个数字，最终得到的结果 也是这两个只出现一次的数字异或的结果。
 *          - 假设最终得到的异或结果为 0010，也就是说： 这两个数字的二进制表示时的第3位，一定是一个为1，一个为0
 *          - 因此 我们可以将数组中的所有数字按第3位是1的分成一组，第3位是0的分成一组。
 *          - 然后，再分别求出两个子数组中的那个只出现过一次的数字吧。
* */
