package edu.neu.xsz.leetcode.lcof.lcof57;
class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int target = 15;
        int[][] ret = sol.findContinuousSequence(target);
        for(var x:ret){
            for(var i:x){
                System.out.printf("%d,",i);
            }
            System.out.println("");
        }
    }
}
