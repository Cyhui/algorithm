package 剑指offer.ch;

import java.util.LinkedList;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * Created by Cyhui on 2018/1/10 0010.
 */
public class Test58 {
    /********************** 递归  *****************/
    boolean isSymmetrical(TreeNode pRoot){
        return isSymmetrical(pRoot,pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot, TreeNode pRoot1) {
        if (pRoot == null && pRoot1 == null){
            return true;
        }else if (pRoot == null || pRoot1 == null){
            return false;
        }
        // 对称位置的值不同
        if (pRoot.val != pRoot1.val){
            return false;
        }
        return isSymmetrical(pRoot.left, pRoot1.right) && isSymmetrical(pRoot.right, pRoot1.left);
    }

    /*********************  迭代  ***************************/
    boolean isSymmetrical1(TreeNode pRoot){
        boolean existed = (pRoot == null || (pRoot.left == null && pRoot.right == null));
        if (existed){
            return true;
        }
        //按层遍历
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(pRoot);
        queue2.offer(pRoot);
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode root1 = queue1.poll();
            TreeNode root2 = queue2.poll();

        }
        return isSymmetrical(pRoot,pRoot);
    }
}
