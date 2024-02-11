package 二叉树;

public class _701_二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }

        if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static class _101_对称二叉树 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isSymmetric(root.left, root.right);
        }

        public boolean isSymmetric(TreeNode L, TreeNode R) {
            if (L == null && R == null) return true;
            if (L == null || R == null || L.val != R.val) return false;
            return isSymmetric(L.left, R.right) && isSymmetric(L.right, R.left);
        }
    }

    public static class _98_验证二叉搜索树 {
        long pre = Long.MIN_VALUE;
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            if (!isValidBST(root.left)) {
                return false;
            }
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            return isValidBST(root.right);
        }
    }

    public static class _543_二叉树的直径 {
        int ans;
        //首先我们知道一条路径的长度为该路径经过的节点数减一，所以求直径（即求路径长度的最大值）等效于求路径经过节点数的最大值减一。
        //而任意一条路径均可以被看作由某个节点为起点，从其左儿子和右儿子向下遍历的路径拼接得到。
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            ans = 1;
            dfs(root);
            return ans - 1;//节点数-1就是路径数
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = dfs(root.left);//根节点的左边经过最大路径的节点数
            int right = dfs(root.right);//根节点的右边经过最大路径的节点数
            ans = Math.max(ans, left + right + 1);
            return Math.max(left, right) + 1;
        }
    }
}
