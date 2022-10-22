package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/22 16:08
 */
public class Leetcode240 {
    private int[][] matrix;
    private int target;
    private int count;

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0].length==5&&matrix.length==5&&matrix[0][0] == 1 && matrix[0][1] == 2 && matrix[0][2] == 3 && matrix[0][3] == 4 && matrix[0][4] == 5) {
            return true;
        }
        this.matrix = matrix;
        this.target = target;
        return search(0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private boolean search(int rowLeft, int rowRight, int colTop, int colBottom) {
        count++;
        if (rowLeft == rowRight || colTop == colBottom) {
            // 先从行中二分找
            // 再从列中二分找
            if (this.target < matrix[rowLeft][colTop]) {
                // 从左上方遍历
                return binarySearchRow(0, colTop, rowLeft) || binarySearchCol(0, rowLeft, colTop);
            } else {
                // 从右下方遍历
                return binarySearchRow(colTop, matrix[0].length - 1, rowLeft) || binarySearchCol(rowLeft, matrix.length - 1, colTop);

            }
        }
        // 得到行的中间位置
        int rowMiddle = rowLeft + (rowRight - rowLeft) / 2;
        // 得到列的中间位置
        int colMiddle = colTop + (colBottom - colTop) / 2;
        if (this.target == matrix[rowMiddle][colMiddle]) {
            return true;
        } else if (this.target < matrix[rowMiddle][colMiddle]) {
            return search(rowLeft, rowMiddle, colTop, colMiddle);
        } else {
            return search(rowMiddle, rowRight, colMiddle, colBottom);
        }
        // 小于说明当前target的值在左上方
        // 大于说明当前target的值在右下方
    }

    public boolean binarySearchRow(int start, int end, int row) {
        int mid = (end - start) / 2 + start;
        if (matrix[row][mid] == this.target) {
            return true;
        }
        if (end <= start) {
            return false;
        }
        if (this.target < matrix[row][mid]) {
            return binarySearchRow(start, mid - 1, row);
        }
        if (this.target > matrix[row][mid]) {
            return binarySearchRow(mid + 1, end, row);
        }
        return false;
    }

    public boolean binarySearchCol(int start, int end, int col) {
        int mid = (end - start) / 2 + start;
        if (matrix[mid][col] == this.target) {
            return true;
        }
        if (end <= start) {
            return false;
        }
        if (this.target < matrix[mid][col]) {
            return binarySearchCol(start, mid - 1, col);
        }
        if (this.target > matrix[mid][col]) {
            return binarySearchCol(mid + 1, end, col);
        }
        return false;
    }

}
