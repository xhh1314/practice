package practice.algorithm.other;

/**
 * 求解二进制整数中1的个数
 *
 * @author lh
 * @date 2018/5/17
 * @since
 */
public class NumberOf1InBinary {

    public static int calculate(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(calculate(-1));
    }
}
