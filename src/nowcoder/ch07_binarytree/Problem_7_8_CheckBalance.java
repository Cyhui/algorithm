package nowcoder.ch07_binarytree;

/**
 * 有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * 给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 * <p>
 * Created by Cyhui on 2017/8/11 0011.
 */
public class Problem_7_8_CheckBalance {
    public boolean check(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        int level = 0;
        getHeight(root, level, res);// 获得以根结点为头的深度
        return res[0];
    }

    private int getHeight(TreeNode head, int level, boolean[] res) {
        // 如果当前 head 为空，则返回当前所到达的深度
        if (head == null) {
            return level;
        }
        // 获得以当前 head 为头的左子树深度
        int LH = getHeight(head.left, level + 1, res);
        // 如果以当前 head 为头的左子树不是 AVL，直接返回当前所到达的深度
        if (!res[0]) {
            return level;
        }
        // 获得以当前 head 为头的右子树深度
        int RH = getHeight(head.right, level + 1, res);
        // 如果以当前 head 为头的右子树不是 AVL，直接返回当前所达到的深度
        if (!res[0]) {
            return level;
        }
        // 比较以当前 head 为头的左子树深度和右子树深度，如果其相差大于 1，
        // 则说明以当前 head 为头的二叉树不是 AVL
        if (Math.abs(LH - RH) > 1) {
            res[0] = false;
        }
        // 最后返回当前以 head 为头的深度
        return Math.max(LH, RH);
    }
}
