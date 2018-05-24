package practice.algorithm.other;

/**
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次扫印出每一个数字
 *
 * @author lh
 * @date 2018/5/16
 * @since
 */
@Deprecated //想不明白边界问题
public class PrintMatrix {


    public static void start(int[][] matrix) {
        int l = matrix.length;
        int h = matrix[0].length;
        int start = 0;
        while (l > start * 2 && h > start * 2) {
            printMatrix(matrix, l - start * 2, h - start * 2, start, start++);
        }


    }

    public static void printMatrix(int[][] matrix, int l, int h, int i, int j) {

        int countL = 0, countH = 0;
        while (countL <= l) {
            System.out.println(matrix[i++][j]);
            countL++;
        }
        j++;
        while (countH < h) {
            System.out.println(matrix[i][j++]);
            countH++;
        }

        i--;
        countL--;
        while (countL > 0) {
            System.out.println(matrix[i--][j]);
            countL--;
        }
        j -= 2;
        countH--;
        while (countH > 0) {
            System.out.println(matrix[i][j--]);
            countH--;
        }


    }

}
