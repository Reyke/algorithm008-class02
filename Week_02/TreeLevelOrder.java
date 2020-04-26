package cn.reyke.lab.week2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
public class TreeLevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();

        if (root == null) return ret;

        Queue<Node> queue = new LinkedList<Node>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<Integer>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }

        return ret;
    }
}
