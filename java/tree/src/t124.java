public class t124 {
}

class Solution124 {
    int ans = Integer.MIN_VALUE;

    int SumOfNode(TreeNode root) {
        //return max value with end in the root
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            ans = Math.max(ans, root.val);
            return root.val;
        }

        int leftVal = SumOfNode(root.left);
        int rightVal = SumOfNode(root.right);
        ans = Math.max(ans, root.val + leftVal + rightVal);
        ans = Math.max(ans, root.val + rightVal);
        ans = Math.max(ans, root.val + leftVal);
        ans = Math.max(ans, root.val);
        return Math.max(Math.max(leftVal, rightVal) + root.val,root.val);
    }


    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        SumOfNode(root);
        return ans;
    }
}