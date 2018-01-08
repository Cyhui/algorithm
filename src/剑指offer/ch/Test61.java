package 剑指offer.ch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化二叉树
 * Created by Cyhui on 2018/1/5 0005.
 */
public class Test61 {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialByPre(root, sb);
        return sb.toString();
    }

    private void serialByPre(TreeNode root, StringBuilder sb) {
        if (root == null){
            sb.append("#!");
        }
        sb.append(root.val+"!");
        serialByPre(root.left,sb);
        serialByPre(root.right, sb);
    }

    TreeNode Deserialize(String str) {
        String[] s = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < s.length; i++) {
            queue.offer(s[i]);
        }
        return reconByPreOrder(queue);
    }

    private TreeNode reconByPreOrder(Queue<String> queue) {
        String root = queue.poll();
        if ("#".equals(root)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(root));
        node.left = reconByPreOrder(queue);
        node.right = reconByPreOrder(queue);
        return node;
    }

    public static void main(String[] args){
        Test61 test61 = new Test61();

    }
}
