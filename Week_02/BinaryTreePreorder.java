package cn.reyke.lab.week2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
public class BinaryTreePreorder {

    // 迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        while(root != null) {
            list.add(root.val);
            if (root.right != null) {
                rights.push(root.right);
            }
            root = root.left;
            if (root == null && !rights.isEmpty()) {
                root = rights.pop();
            }
        }
        return list;
    }
}



