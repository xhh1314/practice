package practice.algorithm.other;

/**
 * 将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
 *
 * @Author
 * @Date ${date}
 */
public class ReverseSentence {

    public static String reverse(String str) {
        if (str == null)
            return str;
        String[] strings = str.split("\\s+");
        int l = 0, r = strings.length - 1;

        //其实不用交换，直接倒着遍历就行了。。。
        while (l < r) {
            String temp = strings[l];
            strings[l++] = strings[r];
            strings[r--] = temp;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < strings.length) {
            stringBuilder.append(strings[i]);
            if (i++ != strings.length - 1)
                stringBuilder.append(" ");
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println(reverse("I like beijing ."));
    }
}
