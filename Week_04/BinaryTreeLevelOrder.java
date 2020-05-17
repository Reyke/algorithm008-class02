package cn.reyke.lab.week4;

import cn.reyke.lab.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/binary-tree-level-order-traversal
// 解法：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
public class BinaryTreeLevelOrder {

    /**
     * 迭代实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) {
            return res;
        }

        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while (queue.size() > 0) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，也放入队列中
            for (int i = 0; i < size; ++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            //将临时list加入最终返回结果中
            res.add(tmp);
        }
        return res;
    }


}
