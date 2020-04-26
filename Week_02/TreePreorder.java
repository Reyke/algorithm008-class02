package cn.reyke.lab.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
public class TreePreorder {
    //1. 递归
    public List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if (root == null)
            return list;

        list.add(root.val);
        for(Node node: root.children)
            preorder(node);

        return list;
    }

    // 2. 迭代
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<Node>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }

        return list;
    }
}

//Definition
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
