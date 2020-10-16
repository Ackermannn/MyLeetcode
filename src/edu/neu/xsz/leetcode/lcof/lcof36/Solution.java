package edu.neu.xsz.leetcode.lcof.lcof36;

// https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/

import java.util.ArrayList;

/**
 * 借助List的方法
 */
public class Solution {
    ArrayList<Node> arr = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        // 中序遍历把arr 存进ArrayList种
        middleScan(root);

        Node last = arr.get(arr.size() - 1);
        Node p;
        // 穿针引线
        for (int i = 0; i < arr.size(); i++) {
            p = arr.get(i);

            p.left = last;

            p.right = arr.get((i + 1) % arr.size());

            last = p;
        }

        return arr.get(0);
    }

    void middleScan(Node root) {
        if (root != null) {
            middleScan(root.left);
            arr.add(root);
            middleScan(root.right);
        }

    }

}
