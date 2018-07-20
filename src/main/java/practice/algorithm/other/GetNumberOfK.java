package practice.algorithm.other;

/**
 * 题目：统计一个数字：在排序数组中出现的次数。
 * 例如输入排序数组｛ 1, 2, 3, 3, 3, 3, 4, 5｝和数字 3 ，
 * 由于 3 在这个数组中出现了 4 次，因此输出 4 。
 *
 * @author lh
 * @date 2018/6/14
 * @since
 */
public class GetNumberOfK {


    public int getNumber(int[] target, int a) {
        if (target == null || target.length == 0)
            return 0;
        int l = 0, r = target.length-1, t = -1, n = 0;
        while (l <= r ) {
            int m = (l + r) / 2;
            if (target[m] > a)
                r = m - 1;
            else if (a > target[m])
                l = m + 1;
            else if (target[m] == a) {
                t = m;
                n++;
                break;
            }
        }
        if (t < 0)
            return 0;
        int temp = t;
        while ((--temp >= 0) && target[temp] == a) {
            n++;
        }
        temp = t;
        while ((++temp < target.length) && target[temp] == a) {
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        GetNumberOfK instance = new GetNumberOfK();
        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
        int[] data6 = {1, 3, 3, 3, 3, 4, 5};
        int[] data8 = {3, 3, 3, 3};
        int[] data9 = {3};

        System.out.println("数组1出现6次数:" + instance.getNumber(data1, 6));
        System.out.println("数组6出现3次数:" + instance.getNumber(data6, 3));
        System.out.println("数组8出现3次数:" + instance.getNumber(data8, 3));
        System.out.println("数组9出现3次数:" + instance.getNumber(data9, 3));

    }

}
