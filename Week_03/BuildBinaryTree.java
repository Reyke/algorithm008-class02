package cn.reyke.lab.week3;

import cn.reyke.lab.data.TreeNode;

import java.util.HashMap;

//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class BuildBinaryTree {

    public TreeNode buildTree(int[] preorder, int[] inorder){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i],i);

        return buildTreeHelper(preorder, 0, preorder.length,inorder, 0, inorder.length, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end,
                                     HashMap<Integer,Integer> map) {
        if(p_start == p_end)
            return  null;
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);

        int i_root_index = map.get(root_val);
        int leftNum = i_root_index - i_start;
        root.left = buildTreeHelper(preorder,p_start +1, p_start + leftNum + 1, inorder, i_start, i_root_index, map);
        root.right = buildTreeHelper(preorder,p_start + leftNum + 1, p_end, inorder, i_start + leftNum + 1, i_end, map);

        return  root;
    }
}
