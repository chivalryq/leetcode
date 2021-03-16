public class t543 {
}

class Solution543 {
    int ans;

    int lenOfNode(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftLen = lenOfNode(root.left);
        int rightLen = lenOfNode(root.right);
        ans = Math.max(ans, leftLen + rightLen);
        return Math.max(leftLen, rightLen) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        lenOfNode(root);
        return ans;
    }
}