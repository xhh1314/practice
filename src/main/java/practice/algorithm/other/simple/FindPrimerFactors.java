package practice.algorithm.other.simple;

import java.util.Scanner;

/**
 * 题目描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 * <p>
 * 详细描述：
 * <p>
 * 函数接口说明：
 * public String getResult(long ulDataInput)
 * 输入参数：
 * long ulDataInput：输入的正整数
 * 返回值：
 * String
 * <p>
 * <p>
 * 输入描述:
 * 输入一个long型整数
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 *
 * @author lh
 * @date 2018/8/2
 * @since
 */
public class FindPrimerFactors {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLong()) {
            long num = in.nextLong();
            printPrimerFactors(num);
        }
    }

    private static void printPrimerFactors(long num) {
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                num /= i;
                System.out.println(i + " ");
            }
        }
    }

}
