package practice.algorithm;

/**
 * 堆实现 为了简单默认用整数
 *
 * @author 李浩
 * @date $date
 */
public class BinaryHeap {

    public static void main(String[] args) {
        
        int[] a = {14, 1, 5, 18, 7, 4, 8};
        BinaryHeapImpl bhi = new BinaryHeapImpl(a.length+1);
        int[] result = bhi.heap;
        for (int i = 0; i < a.length; i++) {
            bhi.insertMax(a[i]);
        }
        bhi.sort();


    }


}

class BinaryHeapImpl {

    int[] heap ;
    private int size = 0;
    public BinaryHeapImpl(int size) {
    	heap=new int[size];
    }

    /**
     * 最小堆插入算法
     *
     * @author 李浩
     * @date 2017/11/27
     * @version 1.0
     */
    public void insert(int v) {
        size++;
        int current = size;
        heap[current] = v;
        while (v < heap[current / 2]) {
            int p = heap[current / 2];
            heap[current / 2] = v;
            heap[current] = p;
            current = current / 2;
        }

    }

    /**
     * 最大堆插入实现
     *
     * @param
     * @return
     * @author 李浩
     * @date 2017/11/27
     * @version
     */
    public void insertMax(int v) {
        size++;
        int current = size;
        heap[current] = v;
        int pi = 0;
        while (heap[(pi = current / 2)] < v && current != 1) {
            int p = heap[pi];
            heap[pi] = v;
            heap[current] = p;
            current = pi;
        }
    }

    /**
     * 最大堆删除实现
     *
     * @param index 要删除的位置
     * @return
     * @author 李浩
     * @date 2017/11/27
     * @version
     */
    public void deleteMax(int index) {
        if (index == size) {
            heap[size] = 0;
            return;
        }
        int child;
        while (true) {
            child = maxChild(index);
            if (child < 0) {
                break;
            }
            heap[index] = heap[child];
            index = child;
        }
        heap[index] = heap[size];
        heap[size] = 0;
        size--;

    }

    /**
     *取得最大子节点的index
     *@author 李浩
     *@date 2017/11/27
     *@version
     *@param
     *@return
    */
    public int maxChild(int pi) {
        if (pi << 1 > size)
            return -1;
        int left = heap[pi << 1];
        int right = heap[(pi << 1) + 1];
        if (left != 0 && right != 0) {
            return left >= right ? pi << 1 : (pi << 1) + 1;
        } else if (left != 0) {
            return pi << 1;
        } else {
            return -1;
        }

    }
    
    /**
     * 实现一个堆排序,使用最大堆删除
     */
    public void sort() {
    	int[] result=heap;
    	while(size>1) {	
    	int index=1;
    	int frist=heap[1];
    	 if (index == size) {
             heap[size] = 0;
             return;
         }
         int child;
         while (true) {
             child = maxChild(index);
             if (child < 0) {
                 break;
             }
             heap[index] = heap[child];
             index = child;
         }
         heap[index] = heap[size];
         heap[size] = frist;
         size--;
    	}
    	
    }

}