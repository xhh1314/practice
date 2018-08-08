package practice.algorithm.other.simple;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * 输入描述:
 * 输入一个有字母和数字以及空格组成的字符串，和一个字符。
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 *
 * @author lh
 * @date 2018/8/1
 * @since
 */
public class SubStringNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        s = s.toLowerCase();
//        String[] split = s.split("\\s+");
//        String parent = split[0];
//        String subString = split[1];
        String parent = null;
        String subString = null;
        parent = scanner.nextLine();
        subString = scanner.nextLine();
        int count = 0;
        char[] p = parent.toCharArray();
        char[] sub = subString.toCharArray();
        for (int i = 0; i < p.length; i++) {
            boolean flag = true;
            for (int j = 0; j < sub.length; j++) {
                if (i < p.length && sub[j] == p[i]) {
                    i++;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
                i--;
            }
        }
        System.out.println(count);
    }

}
