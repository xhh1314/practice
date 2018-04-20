package practice.algorithm;

import java.util.Random;

/**
 * 堆排序实现 ,使用的是最小堆
 * 2018-03-31
 */
public class SortByBinaryHeap {

    int[] source = new int[11];
    int currentSize = 0;

    /**
     * 上滤实现插入
     *
     * @param target
     */
    public void insert(int target) {
        //数组第一个位置不存数
        if (currentSize == source.length - 1)
            throw new RuntimeException("数组已满！");
        int hold = ++currentSize;
        while (hold / 2 > 0 && target < source[hold / 2]) {
            source[hold] = source[hold / 2];
            hold = hold / 2;
        }
        source[hold] = target;
    }


    /**
     * 删除最小值，在删除根部最小值之后，需要把最后一个数拿出来，进行下滤，重新调整堆
     *
     * @return 返回最小值
     */
    public int deleteMin() {
        int min = source[1];
        //最后一个数
        int temp = source[currentSize];
        int hold = 1;
        while (hold * 2 <= currentSize) {
            int child = hold * 2;
            if (child != currentSize && source[child + 1] < source[child]) {
                child++;
            }
            if (source[child] < temp) {
                source[hold] = source[child];
            } else {
                break;
            }
            hold = child;
        }
        //这里处理的很精妙，避免多次交换
        source[hold] = temp;
        currentSize--;
        return min;
    }

    /**
     * 排序
     */
    public void sort() {
        //排序的时候要长度减-1，因为第一个位置不存数
        for (int i = 0; i < source.length - 1; i++) {
            int min = deleteMin();
            source[currentSize + 1] = min;
        }

    }


    public static void main(String[] args) {
        SortByBinaryHeap binaryHeap = new SortByBinaryHeap();
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            int a = random.nextInt(30) + 1;
//            binaryHeap.insert(a);
//        }
//        binaryHeap.sort();
        int[] array = {1, 10, 8, 20, 22, 11, 11, 13, 6, 7};
        binaryHeap.sort2(array);
        for (int i = 0; i < array.length; i++)
            System.out.println("最终结果是:" + array[i]);

    }

    //--------------------------------------堆排序第二个版本，最大堆排序,直接根据一个无序数组排序，数组第一个数有数的情况--------------------------------

    /**
     * 从数组某一个位置开始进行下滤
     *
     * @param source 源数组
     * @param i      开始的位置
     * @param length 数组长度
     */
    public void predown(int[] source, int i, int length) {
        int temp = source[i];
        //左子树位置小于等于最后一个位置
        while (i * 2 + 1 <= length - 1) {
            int child = i * 2 + 1;
            if (child != length - 1 && source[child] < source[child + 1])
                child++;
            if (temp < source[child]) {
                source[i] = source[child];
            } else {
                break;
            }
            i = child;
        }
        source[i] = temp;
    }


    public void sort2(int[] source) {
        int length = source.length;
        //构建堆
        for (int i = length / 2 - 1; i >= 0; i--) {
            predown(source, i, length);
        }
        //排序
        for (int i = length - 1; i > 0; i--) {
            //交换首尾位置
            int temp = source[0];
            source[0] = source[i];
            source[i] = temp;
            //再进行下虑重新构建堆
            predown(source, 0, i);
        }


    }


}
