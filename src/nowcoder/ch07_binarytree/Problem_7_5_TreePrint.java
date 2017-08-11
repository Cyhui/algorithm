package nowcoder.ch07_binarytree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * 给定二叉树的根结点root，请返回打印结果，
 * 结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，
 * 且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 * <p>
 * Created by Cyhui on 2017/8/10 0010.
 */
public class Problem_7_5_TreePrint {
    public int[][] printTree(TreeNode root) {
        // write code here
        if (root == null){
            return null;
        }

        TreeNode last = root;
        TreeNode nlast = root;

        ArrayList<LinkedList<Integer>> levels = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        int line = 0;
        levels.add(line,new LinkedList<Integer>());

        while (!queue.isEmpty()) {
            TreeNode now = queue.poll();
            levels.get(line).add(now.val);

            if (now.left != null) {
                queue.add(now.left);
                nlast = now.left;
            }
            if (now.right != null) {
                queue.add(now.right);
                nlast = now.right;
            }

            if (last == now && !queue.isEmpty()) {
                last = nlast;
                line++;
                levels.add(line, new LinkedList<Integer>());
            }

        }

        int[][] arr = new int[levels.size()][];
        for (int i = 0; i < levels.size(); i++) {
            int length = levels.get(i).size();
            arr[i] = new int[length];
            for (int j = 0; j < length; j++) {
                arr[i][j] = levels.get(i).get(j);
            }
        }
        return arr;
    }
}
