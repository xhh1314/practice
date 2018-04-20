package practice.algorithm;

import java.util.Arrays;

/**
 * 实现一个trie树
 * 子串使用固定数组存储
 */
public class TrieTest {


    public static void main(String[] args) {
        TrieTest trie = new TrieTest();

        trie.insert("abcd");
        trie.insert("abdd");
        trie.insert("abdc");

        System.out.println(trie.root);

    }


    Node root = new Node('0');

    /**
     * 定位字符串应该插入的位置,必要时创建Node并且返回
     * @param begin
     * @param v
     * @return
     */
    Node createNode(Node begin, char v) {
        Node temp;
        int i = 0;
        while ((temp = begin.next[i]) != null && temp.v != v) {
            i++;
        }

        if (temp == null) {
            temp = new Node(v);
            begin.next[i]=temp;
            return temp;
        } else {
            return temp;
        }

    }


    /**
     * +
     *
     * @param target
     * @return
     */
    public int insert(String target) {
        char[] strs = target.toCharArray();
        Node temp = root;
        for (int i = 0; i < strs.length; i++) {
            temp = createNode(temp, strs[i]);
            if (i == strs.length - 1) {
                temp.count = ++temp.count;
                temp.exist = true;

            }

        }
        return temp.count;

    }


    static class Node {
        char v;
        Node[] next = new Node[26];
        //是否构成单词
        boolean exist = false;
        //出现的次数
        int count = 0;

        Node(char v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", next=" + Arrays.toString(next) +
                    ", exist=" + exist +
                    ", count=" + count +
                    '}';
        }
    }
}
