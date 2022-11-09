package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/11/9 13:52
 */
public class Leetcode79 {

    private char[][] board;
    private char[] words;
    private boolean result = false;
    private boolean[][] step;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.words = word.toCharArray();
        // 用于保存哪些路是走过的
        this.step = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从第一个元素开始匹配
                backTracking(i, j, 0);
                if (this.result) {
                    return true;
                }
            }
        }
        return false;
    }

    private void backTracking(int row, int col, int index) {
        // 只有当前字符匹配words单词列表它才有资格继续递归
        if (board[row][col] == words[index]) {
            if (index == words.length - 1) {
                this.result = true;
                return;
            }
            step[row][col] = true;
            // 接下来有四个方向可以选择,往右走
            if (!result && col < this.board[0].length - 1 && !step[row][col + 1]) {
                backTracking(row, col + 1, index + 1);
            }
            // 往下走
            if (!result && row < this.board.length - 1 && !step[row + 1][col]) {
                backTracking(row + 1, col, index + 1);
            }
            // 往左走
            if (!result && col > 0 && !step[row][col - 1]) {
                backTracking(row, col - 1, index + 1);
            }
            // 往上走
            if (!result && row > 0 && !step[row - 1][col]) {
                backTracking(row - 1, col, index + 1);
            }
            step[row][col] = false;
        }
    }

}
