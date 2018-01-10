package 剑指offer.ch;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 按Z字型打印二叉树
 *    相关题目：Test60
 * Created by Cyhui on 2018/1/10 0010.
 */
public class Test59 {
    /**
     *  1.从左到右的过程中，从dq的头部弹出节点，如果弹出的节点没有孩子节点，不放人结点到dq中，如果有孩子结点，
     *     先让左孩子从尾部进入dq，再让右孩子从尾部进入dq
     *  2.从右到左的过程中，从dq的尾部弹出节点，如果弹出的节点没有孩子节点，不放人结点到dq中，如果有孩子结点，
     *     先让右孩子从头部进入dq，再让左孩子从头部进入dq
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> listall = new ArrayList<>();
        if (pRoot == null){
            return listall;
        }
        // 表示打印顺序 true 为从左到右  false为从右到左
        boolean lr = true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(pRoot);

        // 当前行的最右点
        TreeNode last = pRoot;
        // 下一行的最右点
        TreeNode nlast = null;

        int line = 0;
        listall.add(line,new ArrayList<>());
        TreeNode node;
        while(!deque.isEmpty()){
            if (lr){
                node = deque.pollFirst();
                listall.get(line).add(node.val);
                if (node.left != null){
                    nlast = nlast == null ? node.left : nlast;
                    deque.offerLast(node.left);
                }
                if (node.right != null){
                    nlast = nlast == null ? node.right : nlast;
                    deque.offerLast(node.right);
                }
            }else{
                node = deque.pollLast();
                listall.get(line).add(node.val);
                if (node.right != null){
                    deque.offerFirst(node.right);
                    // 记录下一层最后一个结点 例 第2层有2 ，3  .  nlast为结点2
                    nlast = nlast == null ? node.right : nlast;
                }
                if (node.left != null){
                    deque.offerFirst(node.left);
                    nlast = nlast == null ? node.left : nlast;
                }
            }
            // 到达当前层的最后一个节点
            if (last == node && !deque.isEmpty()){
                lr = !lr;
                last = nlast;
                nlast = null;
                listall.add(++line,new ArrayList<>());
            }
        }
        return listall;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n11 = new TreeNode(4);
        TreeNode n21 = new TreeNode(5);
        TreeNode n22 = new TreeNode(6);
        TreeNode n211 = new TreeNode(7);

        root.left = n1;
        root.right = n2;

        n1.left = n11;

        n2.left = n21;
        n2.right = n22;

        n21.left = n211;
        Test59 test59 = new Test59();
        test59.Print(root);
    }
}
