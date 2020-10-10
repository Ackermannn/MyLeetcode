package edu.neu.xsz.leetcode.lcof.lcof09;

public class Main {
    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(5);
        int param_5 = obj.deleteHead();
        System.out.println(param_5);
    }
}
