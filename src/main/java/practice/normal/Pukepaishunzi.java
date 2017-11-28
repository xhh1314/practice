package practice.normal;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
 * 如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
 * 他想了想,决定大\小
 * 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So
 * Lucky!”。 LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 * 
 * @author lh
 * @date 2017年10月17日
 * @version 这里直接抽象成14张牌，0随意代表
 */
public class Pukepaishunzi {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] source = { 0, 1, 2, 3, 4, 5, 6, 7 };
		int i = 0, count = 0;
		while (i < 1000000) {
			count += probability(rand, source);
			i++;
		}
		float p = (float) count / i;
		System.out.println("顺子的概率为:" + p);

	}

	static int probability(Random rand, int[] source) {

		int[] val = new int[5];
		initialVal(val, rand, source);
		// 排序完再传入
		// Arrays.sort(val);
		return shunzi(val) ? 1 : 0;

	}

	static void initialVal(int[] val, Random rand, int[] source) {
		int i = 0;
		int len = 0;
		while (i < 5) {
			while (len <= 4) {
				int b = rand.nextInt(source.length);
				// System.out.println(b);
				if (!findValue(val, source[b])) {
					val[i++] = source[b];
					len++;
					break;
				}
			}

		}
	}

	static boolean findValue(int[] s, int v) {
		for (int e : s) {
			if (e == v) {
				return true;
			}

		}
		return false;
	}

	static boolean shunzi(int[] val) {
		if (val.length != 5)
			throw new IllegalArgumentException();
		// 是否顺子标志位
		sort(val);
		boolean flag1 = true;
		boolean flag2 = true;
		// 查找看是否有0
		boolean zero = false;
		for (int v : val) {
			if (v == 0) {
				zero = true;
				break;
			}
		}
		// 有0的情况
		if (zero) {
			int v1, v2 = 0;
			int replace = 0;
			// 有0则首位是0，直接跳过第一位
			for (int i = 1; i < val.length - 1; i++) {
				v1 = val[i];
				v2 = val[i + 1];
				if (v1 + 1 == v2)
					continue;
				if (v1 + 2 == v2)
					replace++;
				else {
					flag1 = false;
					break;
				}
				if (replace > 1) {
					flag1 = false;
					break;
				}

			}
			// 正序遍历失败，再反序遍历
			if (!flag1) {
				for (int i = val.length - 1; i >= 2; i--) {
					v1 = val[i];
					v2 = val[i - 1];
					if (v1 - 1 == v2)
						continue;
					if (v1 - 2 == v2)
						replace++;
					else {
						flag2 = false;
						break;
					}
					// 替换达到2次，则失败
					if (replace > 1) {
						flag2 = false;
						break;
					}

				}
			}
		}
		// 不包含0的情况
		else {
			int v1, v2 = 0;
			for (int i = 0; i < val.length - 1; i++) {
				v1 = val[i];
				v2 = val[i + 1];
				if (v1 + 1 != v2) {
					flag1 = false;
					break;
				}
			}
			if (!flag1) {
				for (int i = val.length - 1; i >= 1; i--) {
					v1 = val[i];
					v2 = val[i - 1];
					if (v1 - 1 != v2) {
						flag2 = false;
						break;
					}
				}

			}
		}

		return flag1 || flag2;
	}

	@Test
	public void test1() {
		int[] val = { 0, 1, 2, 3, 5 };
		System.out.println(shunzi(val));
	}

	static void sort(int[] val) {

		for (int i = 1; i < val.length; i++) {
			int j = i;
			int temp;
			while (j >= 1 && val[j - 1] > val[j]) {
				temp = val[j - 1];
				val[j - 1] = val[j];
				val[j] = temp;
				j--;
			}

		}

	}

}
