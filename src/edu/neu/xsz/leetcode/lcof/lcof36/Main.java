package edu.neu.xsz.leetcode.lcof.lcof36;

public class Main {
    public static void main(String[] args) {
//        Solution solution = new Solution();
        Solution2 solution = new Solution2();

        Node[] Nodes = new Node[5];
        for (int i = 0; i < 5; i++) {
            Nodes[i] = new Node(i + 1);

        }
        Nodes[3].left = Nodes[1];
        Nodes[3].right = Nodes[4];
        Nodes[1].left = Nodes[0];
        Nodes[1].right = Nodes[2];

        Node ret = solution.treeToDoublyList(Nodes[3]);
        System.out.println("DONE!");
    }
}
