package Hot100.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversalRecursion(root,ans);
        return ans;
    }

    public static List<Integer> inorderTraversalRecursion(TreeNode root,List<Integer> ans) {

        if (root!=null){
            ans = inorderTraversalRecursion(root.left,ans);

        }else {
            return ans;
        }
        ans.add(root.val);
        ans = inorderTraversalRecursion(root.right,ans);
        return ans;
    }
}
