import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    TreeNode reCon(ArrayList<Integer> pre, ArrayList<Integer> in) {
        if (pre.size() == 0) {
            return null;
        }
        if (pre.size() == 1) {
            return new TreeNode(pre.get(0));
        }
        TreeNode root = new TreeNode(pre.get(0));
        int lnum = in.indexOf(pre.get(0));
        ArrayList<Integer> preLeft = new ArrayList<>();
        ArrayList<Integer> preRight = new ArrayList<>();
        ArrayList<Integer> inLeft = new ArrayList<>();
        ArrayList<Integer> inRight = new ArrayList<>();
        for (int i = 0; i < lnum; i++) {
            inLeft.add(in.get(i));
            preLeft.add(pre.get(i + 1));
        }
        for (int i = lnum + 1; i < in.size(); i++) {
            inRight.add(in.get(i));
            preRight.add(pre.get(i));
        }
        root.left = reCon(preLeft, inLeft);
        root.right = reCon(preRight, inRight);
        return root;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> i = new ArrayList<>();
        for (int x : pre) {
            p.add(x);
        }
        for (int x : in) {
            i.add(x);
        }
        return reCon(p, i);
    }
}