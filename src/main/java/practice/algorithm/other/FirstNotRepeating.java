package practice.algorithm.other;

/**
 * 题目：在字符串中找出第一个只出现一次的字符。
 * 例如输入"abaccdeff"，则输出'b'。
 *
 * @author lh
 * @date 2018/4/22
 * @since
 */
public class
FirstNotRepeating {

    public char firstRepeatChar(String str) {
        if (str == null)
            return 0;
        char[] strChars = str.toCharArray();
        //ASCII编码占用8bit,所以有256种字符，需要256长度存储
        int[] hashTable = new int[256];
        for (int i = 0; i < strChars.length; i++) {
            hashTable[strChars[i]] = hashTable[strChars[i]] + 1;
        }

        for (int i = 0; i < strChars.length; i++) {
            if (hashTable[strChars[i]] == 1)
                return strChars[i];
            i++;
        }

        return 0;

    }


    public static void main(String[] args) {
        FirstNotRepeating repeating = new FirstNotRepeating();
        System.out.println(repeating.firstRepeatChar("googyle"));
        System.out.println("3%62:"+3%62);
    }

}

/*
* 解题思路:
* 1、蛮力法
* 2、使用hash表来统计每个字符出现的次数，但这里肯定不能用库函数的HashMap，所以可以根据ASCII编码，以每个字符的编码值作为key，存放到int数组中
* 以此来统计每个字符出现的次数,最后遍历字符数组，根据key去hash表中取数出现的次数
* */
