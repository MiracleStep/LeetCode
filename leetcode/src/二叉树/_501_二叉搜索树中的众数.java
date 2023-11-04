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

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //匿名内部类
        int[] res = list.stream().mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer value) {
                return value.intValue();
            }
        }).toArray();
        //lambda
        int[] res2 = list.stream().mapToInt(value -> value.intValue()).toArray();
        //方法的引用
        int[] res3 = list.stream().mapToInt(Integer::intValue).toArray();
    }
    // 中序遍历
    public void inOrder(TreeNode root, List<Integer> lst) {
        if (root == null) {
            return;
        }
        inOrder(root.left, lst);
        lst.add(root.val);
        inOrder(root.right, lst);
    }

    public int[] findMode2(TreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();
        inOrder(root, lst);
        // 记录前一个元素值
        int pre = lst.get(0);
        // 记录次数
        int cnt = 1;
        // 记录最大次数
        int maxCnt = 1;
        // 记录结果
        List<Integer> res = new ArrayList<Integer>();
        res.add(lst.get(0));
        for(int i = 1; i < lst.size(); i++){
            // 如果与前一个节点的值相等
            if(pre == lst.get(i)){
                cnt += 1;
            }
            else{
                cnt = 1;
            }
            // 如果和最大次数相同，将值放入 res
            if (cnt == maxCnt){
                res.add(lst.get(i));
            }
            // 如果大于最大次数
            else if(cnt > maxCnt){
                // 更新最大次数
                maxCnt = cnt;
                // 重新更新 res
                res.clear();
                res.add(lst.get(i));
            }
            pre = lst.get(i);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
