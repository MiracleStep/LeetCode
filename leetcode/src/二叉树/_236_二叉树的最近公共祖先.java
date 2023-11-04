package 二叉树;

public class _236_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //根节点为空直接返回null
        if(root == null) return null;
        //三种情况：根节点为所求node，p为node、q为node
        // 如果 root 等于 p 或者 q，那最近公共祖先一定是 p 或者 q
        if(root == p || root == q){
            return root;
        }


        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //如果left和right都非空说明都递归到root==p、q的情况，说明p和q在root节点的左右子树
        //root为所求
        if(left != null && right != null){
            return root;
        }
        //left!=null说明root的左子节点有p和q那么先递归到的节点为所求的最近公共祖先
        else if(left != null && right == null){
            return left;
        }
        else if(left == null && right != null){
            return right;
        }
        //如果都为空，那么没有.
        else {
            return null;
        }
    }
}
