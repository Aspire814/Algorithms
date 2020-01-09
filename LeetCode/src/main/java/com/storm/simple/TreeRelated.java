package com.storm.simple;

import java.util.ArrayList;
import java.util.List;

import com.storm.common.TreeNode;


public class TreeRelated {
    /**
     * 二叉树 判同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && !isSameTree(p.right, q.right);
    }

    /**
     * 二叉树镜像
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSameTree(left.right, right.left);
    }

    /**
     * 二叉树最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftdepth = maxDepth(root.left);
            int rightdepth = maxDepth(root.right);
            return Math.max(leftdepth, rightdepth) + 1;
        }
    }

    /**
     * 自底向上层次遍历二叉树
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        // list.add(index, element);
        return null;
    }
}
