package cnsukidayo.com.gitee.leetcode;

import cnsukidayo.com.gitee.script.Node;

/**
 * @author: sukidayo
 * @date: 2022/10/29 10:03
 */
public class Leetcode558 {
    public Node intersect(Node quadTree1, Node quadTree2) {
        // 递归出口
        if (quadTree1.isLeaf || quadTree2.isLeaf) {
            if (quadTree1.isLeaf && quadTree1.val) {
                return quadTree1;
            } else if (quadTree2.isLeaf && quadTree2.val) {
                return quadTree2;
            } else if (quadTree1.isLeaf) {
                return quadTree2;
            } else {
                return quadTree1;
            }
        }

        Node root = new Node(true, false);

        // 构建左上子树
        root.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        // 构建右上子树
        root.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        // 构建左下子树
        root.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        // 构建右下子树
        root.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (root.topLeft.val && root.topRight.val && root.bottomLeft.val && root.bottomRight.val && root.topLeft.isLeaf && root.topRight.isLeaf && root.bottomLeft.isLeaf && root.bottomRight.isLeaf) {
            return new Node(true, true);
        } else if (!root.topLeft.val && !root.topRight.val && !root.bottomLeft.val && !root.bottomRight.val && root.topLeft.isLeaf && root.topRight.isLeaf && root.bottomLeft.isLeaf && root.bottomRight.isLeaf) {
            return new Node(false, true);
        }
        return root;
    }

}
