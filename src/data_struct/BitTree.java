package data_struct;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树
 */
public class BitTree extends TreeNode {

    public BitTree(int x) {
        super(x);
    }


    /**
     * 输入一个int数组中序遍历 生成二叉树,
     * <p>
     * 例子：
     * Integer[] nums = {1, 2, 3, null, 5};
     * 输出：
     *  1
     * / \
     * 2   3
     * \
     * 5
     *
     * @param nums 层序遍历的二叉树
     * @return
     */
    public static BitTree creatABitTree(Integer[] nums) {

        if (nums.length == 0 || nums[0] == null) return null;
        if (nums.length == 1) return new BitTree(nums[0]);

        Queue<TreeNode> queue = new LinkedList<>();  // 得用队列
        // 根结点的处理
        BitTree node = new BitTree(nums[0]);
        queue.offer(node);

        TreeNode temp;
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

    /**
     * 前序遍历
     *
     */
    public static void preOrderTraverse(TreeNode bitTree) {
        if (bitTree != null) {
            System.out.print(bitTree.val + " ");
            preOrderTraverse(bitTree.left);
            preOrderTraverse(bitTree.right);
        }
    }

    /**
     * 中序遍历
     * @param
     */
    public static void inOrderTraverse(TreeNode bitTree) {
        if (bitTree != null) {
            inOrderTraverse(bitTree.left);
            System.out.print(bitTree.val + " ");
            inOrderTraverse(bitTree.right);
        }
    }

    /**
     *  后序遍历
     * @param
     */
    public static void postOrderTraverse(TreeNode bitTree){
        if (bitTree != null) {
            postOrderTraverse(bitTree.left);
            postOrderTraverse(bitTree.right);
            System.out.print(bitTree.val + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        BitTree bitTree = BitTree.creatABitTree(nums);
        BitTree.postOrderTraverse(bitTree);

    }

}
