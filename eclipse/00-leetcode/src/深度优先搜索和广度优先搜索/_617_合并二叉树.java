package 深度优先搜索和广度优先搜索;

import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.Queue;

public class _617_合并二叉树 {
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
			if(root1==null) {
				return root2;
			}
			
			if(root2 == null) {
				return root1;
			}
			
			TreeNode merged = new TreeNode(root1.val+root2.val);
			merged.left = mergeTrees(root1.left, root2.left);
			merged.right = mergeTrees(root1.right, root2.right);
			return merged;
    }
}
