package Hot100.tree;

public class InvertBinaryTree {
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null &&root.right == null)){
            return root;
        }
        TreeNode x1 = new TreeNode();
        TreeNode x2 = new TreeNode();

        x1 = invertTree(root.left);
        x2 = invertTree(root.right);

        root.right = x1;
        root.left = x2;

        return root;
    }
}
