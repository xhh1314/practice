package practice.algorithm.other;

/**
 * 给出一个n，打印出1到n位数最大值，比如输入3，则打印出1,2,3.......999
 *
 * @author lh
 * @date 2018/4/24
 * @since
 */
public class PrintMaxNumber {

    /**
     * 这是一道错误的解法，因为题目没有说明n最大是多大，存在数字溢出问题，应该把问题转换成一个字符串来求解
     *
     * @param n
     */
    @Deprecated
    public void print(int n) {
        if (n <= 0)
            return;
        long max = 1;
        for (int i = 1; i <= n; i++) {
            max *= 10;
        }

        for (int i = 1; i < max; i++) {
            System.out.println(i);
        }

    }


}
