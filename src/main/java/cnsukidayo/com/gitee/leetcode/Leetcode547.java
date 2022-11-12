package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/11/12 15:13
 */
public class Leetcode547 {


    private int[][] isConnected;

    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;
        int result = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[i][i] == 1) {
                result++;
                forEach(i);
            }
        }
        return result;
    }

    private void forEach(int index) {
        isConnected[index][index] = 0;
        for (int i = index; i < isConnected[index].length; i++) {
            if (isConnected[index][i] == 1) {
                isConnected[index][i] = 0;
                isConnected[i][index] = 0;
                forEach(i);
            }
        }
    }

}
