package practice.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author lh
 * @date 2018/7/20
 * @since
 */
public class GenerateParenthesis {
    private void generateP(List<String> result, String sub, int l, int r) {
        if (r < l)
            return;
        if (l > 0) {
            generateP(result, sub + "(", l - 1, r);
        }
        if (r > 0)
            generateP(result, sub + ")", l, r - 1);
        if (l == 0 && r == 0)
            result.add(sub);
    }

    public static void main(String[] args) {
        GenerateParenthesis instance = new GenerateParenthesis();
        List<String> result = new ArrayList<>(32);
        instance.generateP(result, "", 5, 5);
        result.stream().forEach(val -> {
            System.out.println(val);
        });
    }

}
/*
* 解题思路:
* 原文链接:https://blog.csdn.net/panzw2015/article/details/53026139
* 不得不说，这个实现实在太牛逼了。
*
* 基本素养，只要见到求所有可能组合的情况（所有可能组合的个数）， 首先立马想几个概念词：DFS、递归、回溯。有了这个直觉，你就省去了大量的时间，直接往递归上去套。接下来就是考虑怎么设计递归函数的问题了，速度自然会快很多。

。。。。。。

换个角度考虑问题，我上面是把左右括号作为一个整体做考虑，然后插入的。我们能不能把左右括号拆开，从左往右写，看看能写出多少可能性？这其实是人类正常的思维方式。由于要写出所有的合法括号组合，先写左括号，左括号全部用完，再写右括号，这将是第一个最容易想到的可能性。
然后呢？肯定需要回溯了。回溯到一个位置，我们不写"("，写一个")"然后再试着写写看。如此往复，所有的可能就全部写出来。此外，这个方法还完美解决了重复情况的可能性。因为每一次新的尝试，都是"新"的尝试，之前从来没有尝试过，所以不可能产生已经出现过的结果。具体可以看下面图帮助理解：



上图可以清楚的看到n=3的时候，这种递归方案的全部过程，从左到右递归，直到紫色回溯的时候，再也找不到其他方案，最终回到最初，全部流程结束。

具体实现，有几个核心的点需要注意。如何实现优先选择写"("? 如何控制回溯? 其实答案就隐含在上面的图片里。



虚线箭头其实就是程序走到最终情况时候，往回一路返回的过程。没返回一次，程序需要检查一下是否还有其他合法情况，如果没有继续返回。直到找到合法情况，进入下一个合法情况。

如何检查是否还有合法情况？很简单，合法括号的含义就是有几个左括号，就必然要对应给几个右括号。那么每一次返回之后，看看是否还有"("可以用，如果有，就用一个左括号，然后进入该情况递归。如果没有，就继续返回。所以，我们需要一个左括号计数器来判断是否还有可以用的左括号。那么如何判断走到最终结果了呢？对了！右括号计数器。当右括号和左括号同时用完的时候，我们就认为走到最终结果了，直接return。

到这里就可以了么？如上图，紫色最终回溯到起点第一个左括号之后，按道理还可以继续回溯，然后第一个字符直接填入一个")"， 结果岂不是就错了。而这种情况是显而易见会发生的。这其实就给我们了一个教训，递归方法不是只需要关注基准条件就可以的，还需要考虑某种情况下是否不合法!这个题就是最好的例子。按照通用逻辑，左括号先写的情况全部试过后，就得试右括号先写的情况了，这种情况下明显是不合法的。处理方法也很简单。每次递归的时候先检查一下剩余的右括号是否小于左括号，如果是的话，说明先写了右括号，不合法直接返回。
* */