package practice.algorithm.other;

/**
 * 函数Math.pow(n,exp) 的实现
 */
@Deprecated
public class Power {

    public double pow(double base, int exponent) {
        if (base == 0d)
            return 0;
        double n = 1.0;
        if (exponent >= 0) {
            for (int i = 1; i <= exponent; i++)
                n = n * base;
        } else {
            for (int i = 0; i > exponent; i--) {
                n = n * base;
            }
            n = 1.0 / n;
        }
        return n;
    }


    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.pow(5, 3));
        Math.pow(5, -1);
        System.out.println(1.13 == 1.130);
        System.out.println(Float.floatToRawIntBits(32.0f));
        System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(32.0f)));
    }

}
/*
* 解题思路：该题看似简单，但是需要考虑base为0 和 exponent为负数的情况
* 该实现方法不是最优解，可以使用递归减少计算量
* */