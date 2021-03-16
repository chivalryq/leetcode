import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class t105 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        new Solution105().buildTree(preorder, inorder);
    }
}

class Solution105 {
    ArrayList<Integer> preorder = new ArrayList<>();
    ArrayList<Integer> inorder = new ArrayList<>();

    TreeNode build(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {

        if (preorder.size() > 0) {
            TreeNode root = new TreeNode(preorder.get(0));
            int indexOfRoot = inorder.indexOf(root.val);
            ArrayList<Integer> leftIn = new ArrayList<>();
            ArrayList<Integer> leftPre = new ArrayList<>();
            ArrayList<Integer> rightIn = new ArrayList<>();
            ArrayList<Integer> rightPre = new ArrayList<>();
            for (int i = 0; i < indexOfRoot; i++) {
                leftIn.add(inorder.get(i));
            }
            for (int i = indexOfRoot + 1; i < inorder.size(); i++) {
                rightIn.add(inorder.get(i));
            }
            for (int i = 0; i < indexOfRoot; i++) {
                leftPre.add(preorder.get(1 + i));
            }
            for (int i = indexOfRoot + 1; i < inorder.size(); i++) {
                rightPre.add(preorder.get(i));
            }
            root.left = build(leftPre, leftIn);
            root.right = build(rightPre, rightIn);
            return root;
        } else {
            return null;
        }

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            this.inorder.add(inorder[i]);
            this.preorder.add(preorder[i]);
        }
        return build(this.preorder, this.inorder);
    }
}
