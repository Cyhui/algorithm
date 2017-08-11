package nowcoder.ch07_binarytree;

import java.util.Stack;

/**
 * Created by Cyhui on 2017/8/10 0010.
 */
public class Problem_7_6_TreeToString {

    public String toString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#!");
            return;
        }
        sb.append(root.val + "!");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
}