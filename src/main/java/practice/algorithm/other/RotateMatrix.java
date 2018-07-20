package practice.algorithm.other;

/**
 *逆时针旋转矩阵
 *@author lh
 *@date 2018/7/10
 *@since
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i=0; i<n/2; i++)
            for (int j=i; j<n-i-1; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=tmp;
            }
    }

    public static void main(String[] args) {
        RotateMatrix instance=new RotateMatrix();
        int[][] matrix=new int[3][3];
        int[] x0={1,5,9,13};
        int[] x1={2,6,10,14};
        int[] x2={3,7,11,15};
        int[] x3={4,8,12,16};
        matrix[0]=x0;
        matrix[1]=x1;
        matrix[2]=x2;
        matrix[3]=x3;
        instance.rotate(matrix);
    }
}
/*
* 解题思路：遍历四分之一矩阵，然后进行旋转
* 旋转过程比较难理解，可以用一个4X4的矩阵对着看，只能debug一个个看了
* */