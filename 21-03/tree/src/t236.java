import java.util.TreeMap;

public class t236 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution236{
    TreeNode ans = null;
    int a, b;

    boolean[] check(TreeNode root) {
        if (root == null) return new boolean[]{false, false};

        boolean[] ret = new boolean[2];
        boolean[] exist1 = check(root.left);
        boolean[] exist2 = check(root.right);
        for (int i = 0; i < 2; i++) {
            ret[0] = exist1[0] || exist2[0];
            ret[1] = exist1[1] || exist2[1];
        }
        if (root.val == a) ret[0] = true;
        if (root.val == b) ret[1] = true;
        if (ret[0] && ret[1] && ans == null) {
            ans = root;
        }

        return ret;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        a = p.val;
        b = q.val;
        check(root);
        return ans;
    }
}