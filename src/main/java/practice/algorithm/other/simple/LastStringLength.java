package practice.algorithm.other.simple;

import java.util.Scanner;

/**
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 * 输出描述:
 * 整数N，最后一个单词的长度。
 *
 * @author lh
 * @date 2018/8/1
 * @since
 */
public class LastStringLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s != null) {
            String[] split = s.split("\\s+");
            System.out.println(split[split.length - 1].length());
        }
    }
}
