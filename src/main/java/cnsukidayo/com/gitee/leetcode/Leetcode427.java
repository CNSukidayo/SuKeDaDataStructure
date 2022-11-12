package cnsukidayo.com.gitee.leetcode;

import cnsukidayo.com.gitee.leetcode.Leetcode558.Node;

/**
 * @author: sukidayo
 * @date: 2022/10/28 18:15
 */
public class Leetcode427 {

    private int[][] grid;

    public Node construct(int[][] grid) {
        this.grid = grid;
        return buildLeaf(0, 0, grid[0].length - 1, grid.length - 1);
    }

    /**
     * @param topX    左上角的X轴坐标
     * @param topY    左上角的Y轴坐标
     * @param bottomX 右下角X轴坐标
     * @param bottomY 右下角Y轴坐标,通过这四个坐标确定唯一要处理的区域
     * @return
     */
    private Node buildLeaf(int topX, int topY, int bottomX, int bottomY) {
        // 退出条件
        if (topX == bottomX) {
            return new Node(grid[topX][topY] != 0, true);
        }
        Node node = new Node(true, false);
        // 构建topLeft
        node.topLeft = buildLeaf(topX, topY, topX + (bottomX - topX) / 2, topY + (bottomY - topY) / 2);
        // 构建topRight
        node.topRight = buildLeaf(topX, topY + (bottomY - topY) / 2 + 1, topX + (bottomX - topX) / 2, bottomY);

        // 构建bottomLeft
        node.bottomLeft = buildLeaf(topX + (bottomX - topX) / 2 + 1, topY, bottomX, topY + (bottomY - topY) / 2);

        // 构建bottomRight
        node.bottomRight = buildLeaf(topX + (bottomX - topX) / 2 + 1, topY + (bottomY - topY) / 2 + 1, bottomX, bottomY);
        if (node.topLeft.val && node.topRight.val && node.bottomLeft.val && node.bottomRight.val && node.topLeft.isLeaf && node.topRight.isLeaf && node.bottomLeft.isLeaf && node.bottomRight.isLeaf) {
            return new Node(true, true);
        } else if (!node.topLeft.val && !node.topRight.val && !node.bottomLeft.val && !node.bottomRight.val && node.topLeft.isLeaf && node.topRight.isLeaf && node.bottomLeft.isLeaf && node.bottomRight.isLeaf) {
            return new Node(false, true);
        }
        return node;
    }

}
