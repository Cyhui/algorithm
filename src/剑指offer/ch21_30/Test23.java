package 剑指offer.ch21_30;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 面试题23: 从上到下打印二叉树  按层遍历
 * Created by Cyhui on 2017/12/31 0031.
 */
public class Test23 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode pNode = queue.poll();
            list.add(pNode.val);
            if (pNode.left != null) {
                queue.offer(pNode.left);
            }
            if (pNode.right != null) {
                queue.offer(pNode.right);
            }
        }
        return list;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}