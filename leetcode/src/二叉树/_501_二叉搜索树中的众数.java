package 二叉树;

import java.net.Inet4Address;
import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _501_二叉搜索树中的众数 {
    //迭代法
    public int[] findMode(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        int count = 0;
        int maxCount = 0;
        TreeNode pre = null;
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tmp = stack.pop();
                if(pre == null){
                    //第一次
                    count++;
                } else if(tmp.val == pre.val){
                    //等于前驱节点的值
                    count++;
                } else {
                    //不等于前驱节点的值
                    count = 1;
                }

                if(count == maxCount){
                    set.add(tmp.val);
                } else if(count > maxCount){
                    maxCount = count;
                    set = new HashSet<>();
                    set.add(tmp.val);
                }
                pre = tmp;
                node = tmp.right;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for(Integer i : set){
            res[index++] = i;
        }
        return res;
    }
    //递归法
    List<Integer> list = new ArrayList<>();
    TreeNode pre = null;
    int count = 0;
    int maxCount = 0;
    public int[] findMode2(TreeNode root) {
        dfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre == null || pre.val != root.val) { //初始或者不等于前驱节点的值 count 直接设置为1
            count = 1;
        } else { //相等
            count++;
        }
        pre = root;
        if (count > maxCount) {//出现当前统计的节点大于之前的最大值就清空列表并重新添加
            list.clear();
            list.add(root.val);
            maxCount = count;
        } else if (count == maxCount) {
            list.add(root.val);
        }

        dfs(root.right);
    }
}
