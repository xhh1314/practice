package practice.algorithm.other;


/**
 * 实现一个函数 stringToInt，实现把字符串转换成整数这个功能，不能使用 atoi 或者其他类似的库函数。
 *
 * @author lh
 * @date 2018/4/28
 * @since
 */
public class ConvertStringToInteger {


    public static int convertStringToInt(String value) {
        if (value == null)
            throw new NumberFormatException();
        int length = value.length(), i = 0;
        char firstChar = value.charAt(i);
        int limit = -Integer.MAX_VALUE;
        boolean negative = false;
        if (!testNumber(firstChar)) {
            if (firstChar == '+')
                i++;
            else if (firstChar == '-') {
                i++;
                limit = Integer.MIN_VALUE;
                negative = true;
            } else {
                throw new NumberFormatException();
            }
        }
        //maxResult是负数
        int multmin = limit / 10;
        int sum = 0;
        while (i < length) {
            if (!testNumber(value.charAt(i)))
                throw new NumberFormatException("不合规的字符");
            int n = value.charAt(i++)-'0';
            //sum是负数
            if (sum< multmin)
                //溢出
                throw new NumberFormatException("溢出!");
            //这里的这个设计特别重要，limit+n 保证数字不会溢出!
            if(sum*10<limit+n)
                throw new NumberFormatException("溢出!");
            sum = sum * 10 - n;
        }
        return negative ? sum : -sum;

    }

    private static boolean testNumber(char v) {
        return v >= '0' && v <= '9';
    }

    public static void main(String[] args) {
        //-2147483648
        System.out.println(Integer.MIN_VALUE);
        int result = convertStringToInt("2147 483647");
        //int result2=Integer.parseInt("2147483649");

    }
}
/*
* 求解思路：
* 要点一: 首先想到的是对异常字符串的判断，然后首先想到的是使用正则去判断，其实没有必要，理解底层原理，直接比较字符的二进制码就能测试出来输入的字符是否合规
* 要点二: 可以使用一个变量记住第一个数是不是正数或者负数，并且做合规判断
* 要点三：使用负数来标识求和的结果，以解决负数大一位的问题，此参考jdk的实现，太精妙了
* */