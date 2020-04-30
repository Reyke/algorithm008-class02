package cn.reyke.lab.week3;

import cn.reyke.lab.data.TreeNode;

//https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/

public class LowestAncestor {

    /**
     *
     * 思路
     * 两个节点p,q分为两种情况：
     *
     * p和q在相同子树中
     * p和q在不同子树中
     * 从根节点遍历，递归向左右子树查询节点信息
     * 递归终止条件：如果当前节点为空或等于p或q，则返回当前节点
     *
     * 递归遍历左右子树，如果左右子树查到节点都不为空，则表明p和q分别在左右子树中，因此，当前节点即为最近公共祖先；
     * 如果左右子树其中一个不为空，则返回非空节点。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null & right != null)
            return root;
        else if (left != null)
            return left;
        else
            return right;
    }
}
