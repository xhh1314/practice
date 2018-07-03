package practice.algorithm.other;

/**
 * 寻找最长回文串，For example, SS = "aba" is a palindrome, SS = "abc" is not.
 *
 * @author lh
 * @date 2018/7/3
 * @since
 */
public class LongestPalindRome {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
/*
* 使用中心扩张法求解,可以先假设一段字符串中某一段字符串为回文串，然后再进行分析
* Time complexity : O(n^2)O(n
​2
​​ ). Since expanding a palindrome around its center could take O(n)O(n) time, the overall complexity is O(n^2)O(n
​2
​​ ).

Space complexity : O(1)O(1).
* */