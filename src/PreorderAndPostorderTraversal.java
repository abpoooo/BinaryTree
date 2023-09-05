//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
public class PreorderAndPostorderTraversal {
    //没做出来
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder, 0, preorder.length-1, postorder, 0, preorder.length-1);
    }

    public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if (postStart > postEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root=new TreeNode(rootVal);
        if (preStart == preEnd) return root;
        int index = postStart;
        for (int i = postStart; i <= postEnd-1 ; i++) {
            if (preorder[preStart + 1] == postorder[i]){
                index = i;
                break;
            }
        }

        int leftPostStart = postStart;
        int leftPostEnd = index;
        int rightPostStart = index + 1;
        int rightPostEnd = postEnd - 1;

        int leftPreStart = preStart + 1;
        int leftPreEnd = leftPostEnd - leftPreStart + preStart + 1;
        int rightPreStart = leftPreEnd + 1;
        int rightPreEnd = preEnd;

        root.left = construct(preorder, leftPreStart, leftPreEnd, postorder, leftPostStart, leftPostEnd);
        root.right = construct(preorder, rightPreStart, rightPreEnd, postorder, rightPostStart, rightPostEnd);
        return root;
    }
}
