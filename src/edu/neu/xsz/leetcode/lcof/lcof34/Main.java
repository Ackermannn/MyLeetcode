package edu.neu.xsz.leetcode.lcof.lcof34;

import edu.neu.xsz.datastruct.BitTree;
import edu.neu.xsz.datastruct.TreeNode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start testing!!!");

        Solution sol = new Solution();

        Integer[] treeArr = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1};
        int sum = 22;
        TreeNode root = BitTree.creatABitTree(treeArr);

        List<List<Integer>> ret = sol.pathSum(root, sum);

        // 打印结果
        System.out.println("[");
        for(var line:ret){
            System.out.print("[");
            for(Integer x:line){
                System.out.printf("%d, ", x);

            }
            System.out.print("]");
            System.out.println("");
        }
        System.out.println("]");

        System.out.println("testing is over");
    }
}
