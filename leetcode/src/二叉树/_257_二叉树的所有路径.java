package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class _257_二叉树的所有路径 {
    //递归
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        getPath(root, list, "");
        return list;
    }

    public void getPath(TreeNode root, List<String> list, String res){
        if(root == null) return;
        StringBuilder sb = new StringBuilder(res);
        sb.append(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            list.add(sb.toString());
        } else {
            sb.append("->");
            getPath(root.left, list, sb.toString());
            getPath(root.right, list, sb.toString());
        }
    }
}
