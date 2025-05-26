package DFS和BFS;

import java.util.HashSet;
import java.util.Set;

public class LCR_157_套餐内商品的排列顺序 {
    //回溯法解决，但不是最优
    Set<String> set = new HashSet<>();
    public String[] goodsOrder(String goods) {
        StringBuilder sb = new StringBuilder();
        boolean[] vis = new boolean[goods.length()];
        dfs(goods, sb, vis, 0);
        String[] ans = new String[set.size()];
        int count = 0;
        for (String str : set) {
            ans[count++] = str;
        }
        return ans;
    }

    private void dfs(String goods, StringBuilder sb, boolean[] vis, int index) {
        if (index == goods.length()) {
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < goods.length(); i++) {
            if (vis[i]) continue;
            sb.append(goods.charAt(i));
            vis[i] = true;
            dfs(goods, sb, vis, index + 1);
            //回溯
            vis[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
