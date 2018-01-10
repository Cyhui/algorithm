package 剑指offer.ch;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 相关题目 Test59
 * Created by Cyhui on 2018/1/5 0005.
 */
public class Test60 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null){
            return null;
        }

        // 当前行的最右点
        TreeNode last = pRoot;
        // 下一行的最右点
        TreeNode nlast = pRoot;

        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);

        int line = 0;
        levels.add(line, new ArrayList<>());

        while(!queue.isEmpty()){
            TreeNode root = queue.poll();
            levels.get(line).add(root.val);

            if (root.left != null){
                queue.offer(root.left);
                nlast = root.left;
            }
            if (root.right != null){
                queue.offer(root.right);
                nlast = root.right;
            }
            if (last == root && !queue.isEmpty()){
                last = nlast;
                line++;
                levels.add(line,new ArrayList<>());
            }
        }
        return levels;
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