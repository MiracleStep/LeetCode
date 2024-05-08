package 二叉树;

public class _450_删除二叉搜索树中的节点 {
    //确定状态(明确函数功能)：删除对应节点，并返回根节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null; //确定初始状态(递归基)：为空，返回null。
        //确定状态转移方程（原问题与子问题的关系）：配合子函数在本级函数中应该如何实现。
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        } else if(root.val < key){
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null && root.right == null){//叶子结点
                return null;
            } else if(root.left != null && root.right == null){//度为1的节点
                return root.left;
            } else if(root.left == null && root.right != null){//度为1的节点
                return root.right;
            } else { //度为2的节点
                TreeNode node = root.right;//右子树根节点
                while(node.left != null){
                    //找右子树的最左节点
                    node = node.left;
                }
                root.val = node.val;
                root.right = deleteNode(root.right, node.val);
            }
        }
        return root;
    }


}
