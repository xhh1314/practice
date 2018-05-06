package practice.algorithm.other;


/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * @author lihao
 * @version 1.0
 * @date 2018/5/6
 */
public class PowerFunction {


    public double power(double base, int exponent) {
        if (equals(base, 0d) && exponent < 0)
            throw new IllegalArgumentException("底数为0指数不能为负数");
        if (exponent == 0)
            return 1d;
        boolean flag = false;
        if (exponent < 0) {
            flag = true;
            exponent = -exponent;
        }
        double result = powerRecursion(base, exponent);
        //exponent如果是负数
        if (flag)
            result = 1.0 / result;

        return result;

    }


    /**
     * 递归实现求n次方
     *
     * @param base
     * @param exponent
     * @return
     */
    private double powerRecursion(double base, int exponent) {
        if (exponent == 1)
            return base;
        double result = powerRecursion(base, exponent / 2);
        result = result * result;
        //如果exponent是奇数的话
        if (exponent % 2 == 1)
            result *= base;
        return result;

    }

    /**
     * 浮点数是不精确的所以不能直接用等号进行比较
     *
     * @param a
     * @param b
     * @return
     */
    private boolean equals(double a, double b) {
        return (a - b) >= -0.00000001 && (a - b) <= 0.00000001;

    }


    public static void main(String[] args) {
        PowerFunction powerFunction = new PowerFunction();
        System.out.println(powerFunction.power(2d, 6));

    }
}
