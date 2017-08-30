package nowcoder.ch07_binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 首先我们介绍二叉树先序序列化的方式，假设序列化的结果字符串为str，
 * 初始时str等于空字符串。先序遍历二叉树，如果遇到空节点，就在str的末尾加上“#!”，
 * “#”表示这个节点为空，节点值不存在，当然你也可以用其他的特殊字符，“!”表示一个值的结束。
 * 如果遇到不为空的节点，假设节点值为3，就在str的末尾加上“3!”。
 *
 * 现在请你实现树的先序序列化。给定树的根结点root，请返回二叉树序列化后的字符串。
 * Created by Cyhui on 2017/8/10 0010.
 */
public class Problem_7_6_TreeToString {

    public String toStringPre(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialByPre(root, sb);
        return sb.toString();
    }

    public String toStringIn(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialByIn(root, sb);
        return sb.toString();
    }

    public String toStringPost(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialByPost(root, sb);
        return sb.toString();
    }

    // 先序序列化
    public void serialByPre(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#!");
            return;
        }
        sb.append(root.val + "!");
        serialByPre(root.left, sb);
        serialByPre(root.right, sb);
    }

    // 中序序列化
    public void serialByIn(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#!");
            return;
        }
        serialByIn(root.left, sb);
        sb.append(root.val + "!");
        serialByIn(root.right, sb);
    }

    // 后序序列化
    public void serialByPost(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#!");
            return;
        }
        serialByPost(root.left, sb);
        serialByPost(root.right, sb);
        sb.append(root.val + "!");
    }

    // 先序反序列化
    public TreeNode reconByPreString(String preString){
        String[] value = preString.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < value.length; i++) {
            queue.offer(value[i]);
        }
        return reconByPreOrder(queue);
    }
    public TreeNode reconByPreOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconByPreOrder(queue);
        head.right = reconByPreOrder(queue);
        return head;
    }

    // 中序反序列化
    public TreeNode reconByInString(String inString){
        String[] value = inString.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < value.length; i++) {
            queue.offer(value[i]);
        }
        return reconByInOrder(queue);
    }
    public TreeNode reconByInOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconByPreOrder(queue);
        head.right = reconByPreOrder(queue);
        return head;
    }

    // 后序反序列化
    public TreeNode reconByPostString(String preString){
        String[] value = preString.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < value.length; i++) {
            queue.offer(value[i]);
        }
        return reconByPostOrder(queue);
    }
    public TreeNode reconByPostOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconByPostOrder(queue);
        head.right = reconByPostOrder(queue);
        return head;
    }
}