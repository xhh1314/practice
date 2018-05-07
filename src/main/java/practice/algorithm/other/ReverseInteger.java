package practice.algorithm.other;

/**
 * 反转一个整数
 *
 * @author lihao
 * @version 1.0
 * @date 2018/5/6
 */
public class ReverseInteger {

    public static int reverseInteger(int x) {

        int result = 0;
        int limit = -Integer.MAX_VALUE;
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
            limit = Integer.MIN_VALUE;
        }
        do {
            int remainder = x % 10;
            if (result < limit / 10)
                return 0;
            //result*10-remainder<limit 的变形，防止溢出
            if (result * 10 < limit + remainder)
                return 0;
            //这里用负数来表示计算结果
            result = 10 * result - remainder;
            x = x / 10;

        }
        while (x >= 1);
        return flag ? result : -result;


    }


    public static void main(String[] args) {
        System.out.println(reverseInteger(102));
    }

}
