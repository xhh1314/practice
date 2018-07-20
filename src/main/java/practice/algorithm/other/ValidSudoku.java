package practice.algorithm.other;

/**
 * 验证一个数独是否合法
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * Input:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 *
 * @author lh
 * @date 2018/7/9
 * @since
 */
public class ValidSudoku {


    public boolean isValidSudoku(char[][] board) {
        if (board == null)
            return false;
        return checkRowAndColumn(board) && checkSubSudoku(board);
    }

    private boolean checkSubSudoku(char[][] target) {
        for (int i = 0; i < 3; i++) {
            int x = i * 3;
            for (int j = 0; j < 3; j++) {
                int y = j * 3;
                int[] temp = new int[10];
                for (int a = x; a < x + 3; a++) {
                    for (int b = y; b < y + 3; b++) {
                        int index = transferCharToInteger(target[a][b]);
                        temp[index] = temp[index] + 1;
                    }
                }
                if (!check(temp)) {
                    return false;
                }
            }

        }
        return true;
    }

    private boolean checkRowAndColumn(char[][] target) {
        for (int i = 0; i < target.length; i++) {
            int[] temp1 = new int[10];
            int[] temp2 = new int[10];
            for (int j = 0; j < target[0].length; j++) {
                int index1 = transferCharToInteger(target[i][j]);
                int index2 = transferCharToInteger(target[j][i]);
                temp1[index1] = temp1[index1]+1;
                temp2[index2] = temp2[index2]+1;
            }
            if (!check(temp1) || !check(temp2)) {
                return false;
            }

        }
        return true;
    }

    private boolean check(int[] temp) {
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] > 1)
                return false;
        }
        return true;
    }

    private int transferCharToInteger(char s) {
        if ('.' == s)
            return 0;
        return s - '0';
    }


}
/*
* 比较麻烦的就是检查小的九宫格时，怎么遍历，思路就是双重for循环，得到左上角的起始坐标，然后再往下遍历即可
* */