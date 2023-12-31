package 二叉树;

import java.util.List;

public class _559_N叉树的最大深度 {

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node root) {
        if(root == null) return 0;
        int maxdepth = 0;
        for(Node node : root.children){
            maxdepth = Math.max(maxdepth, maxDepth(node));
        }
        maxdepth += 1;
        return maxdepth;
    }
}
