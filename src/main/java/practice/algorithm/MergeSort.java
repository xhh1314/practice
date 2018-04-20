package practice.algorithm;

/**
 * 实现一个归并排序算法
 */
public class MergeSort {
    public static void main(String[] args) {

        int[] test = {2, 5, 3, 22, 33, 8, 15};
        //int[] test = {2, 5, 3};
      //  int[] r = sort(test);
        MergeSort2 m=new MergeSort2(test);
        m.sort(0,test.length-1);
        int[] result=m.target;

    }

    public static int[] sort(int[] target) {
        int l = target.length;
        if (l < 2) {
            return target;
        }
        //这里应该做一下改进，不用特意拆分为a b 两个数组
        //但是如果不拆分应该无法进行递归,下次有空再研究下
        int[] a = new int[l / 2];
        int[] b = new int[l - a.length];
        for (int i = 0; i < l / 2; i++) {
            a[i] = target[i];
        }
        for (int j = l / 2, i = 0; j < l; j++) {
            b[i++] = target[j];
        }
        a = sort(a);
        b = sort(b);

        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        int temp;
        while (i <= a.length - 1 && j <= b.length - 1) {
            if (a[i] < b[j]) {
                result[k++] = a[i];
                i++;
            } else if (a[i] > b[j]) {
                result[k++] = b[j];
                j++;
            } else {
                result[k++] = a[i++];
                result[k++] = b[j++];
            }
        }
        if (i <= a.length - 1) {
            while (i <= a.length - 1) {
                result[k++] = a[i++];
            }
        }
        if (j <= b.length - 1) {
            while (j <= b.length - 1) {
                result[k++] = b[j++];
            }
        }
        return result;
    }


}

/**
 * 重新实现一个归并排序，不复制数组的实现
 */
class MergeSort2 {

    int[] temp;
    int[] target;

    public void sort(int a,int b){
        if(a<b){
            int center=(a+b)/2;
            merge(a,center+1,b);

        }

    }

    public void merge(int l,int c,int r){
        int i=l,j=c,t=l;
        while(i<=c-1 && j<=r){
            if(target[i]<target[j]){
                temp[t++]=target[i++];
            }else if(target[i]>target[j]){
                temp[t++]=target[j++];
            }else{
                temp[t++]=target[i++];
                temp[t++]=target[j++];
          //  sort(a,center);
          //  sort(center+1,b);
            }

        }
            while(i<=c-1){
                temp[t++]=target[i++];
            }
           while(j<=r){
                temp[t++]=target[j++];
           }

           t--;

        while(t>=l){
               target[t]=temp[t--];
        }

    }
    public MergeSort2(int[] target){
        this.target=target;
        this.temp=new int[target.length];
    }



}
