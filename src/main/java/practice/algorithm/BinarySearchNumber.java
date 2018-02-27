package practice.algorithm;


/**
 * 有序数组中使用二分查找一个数
 */
public class BinarySearchNumber {

    public int find(int[] target,int v){
        int l=0,r=target.length-1,c=0;
        int t=0;
        while (l<r){
            c=(l+r)/2;
            if(v==target[(t=l)] || v==target[t=c] || v==target[t=r]){
                break;
            }
            if(v>target[c]){
                l=c+1;
            }else {
                r=c-1;
            }

        }
        return t;


    }

    public static void main(String[] args) {
        BinarySearchNumber binarySearchNumber=new BinarySearchNumber();
        int[] target={1,2,3,5,7,9,11,23,24,26};
        System.out.println(binarySearchNumber.find(target,11));

    }

}
