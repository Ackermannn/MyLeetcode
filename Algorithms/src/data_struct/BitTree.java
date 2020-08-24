package data_struct;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树
 */
public class BitTree {
    public int val;
    public BitTree left;
    public BitTree right;

    public BitTree(int x) {
        val = x;
    }


    /**
     * 输入一个int数组中序遍历 生成二叉树,
     *
     * 例子：
     * Integer[] nums = {1, 2, 3, null, 5};
     * 输出：
     *    1
     *   / \
     *  2   3
     *   \
     *    5
     * @param nums 层序遍历的二叉树
     * @return
     */
    public static BitTree creatABitTree(Integer[] nums) {

        if (nums.length == 0 || nums[0] == null) return null;
        if (nums.length == 1) return new BitTree(nums[0]);

        Queue<BitTree> queue = new LinkedList<>();  // 得用队列
        // 根结点的处理
        BitTree node = new BitTree(nums[0]);
        queue.offer(node);

        BitTree temp;
        for (int i = 1; i < nums.length; ) {
            temp = queue.poll();
            if (nums[i] != null) {
                assert temp != null;
                temp.left = new BitTree(nums[i++]);
                queue.offer(temp.left);
            } else i++;
            if (i >= nums.length) break;
            if (nums[i] != null) {
                assert temp != null;
                temp.right = new BitTree(nums[i++]);
                queue.offer(temp.right);
            } else i++;
        }


        return node;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 3, null, 5};
        BitTree ret = BitTree.creatABitTree(nums);
    }

}
