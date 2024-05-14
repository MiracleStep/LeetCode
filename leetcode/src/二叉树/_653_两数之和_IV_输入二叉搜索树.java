package 二叉树;

import java.util.HashSet;
import java.util.Set;

public class _653_两数之和_IV_输入二叉搜索树 {
    int target;
    Set<Integer> set = new HashSet<>();//和两数相加一样，都是hash表存储之前遍历的值。
    public boolean findTarget(TreeNode root, int k) {
        //直接在当前函数递归不太合适，因为确定状态不是题目所给的函数要求。因此写一个dfs函数用来递归。
        target = k;
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) return false;
        if (set.contains(target - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left) || dfs(root.right);
    }
}
