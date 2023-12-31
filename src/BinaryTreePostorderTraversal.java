//https://leetcode.com/problems/binary-tree-postorder-traversal/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public void traversal(TreeNode root, List<Integer> list){

        if (root == null) return;
        traversal(root.left, list);
        traversal(root.right,list);
        list.add(root.val);

    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }
}
