package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;
import utils.DSUtils;

public class TreeFromInAndPost {

    private static int Post_order_index = DSUtils.IN_ORDER.length-1;

    public static void main(String[] args) {

        TreeNode root = constructTreeFromInAndPostOrderTraversal(DSUtils.IN_ORDER, DSUtils.POST_ORDER, 0, DSUtils.IN_ORDER.length-1);
        TraverseWithoutRecursion.preOrderTraversal(root);
    }

    public static TreeNode constructTreeFromInAndPostOrderTraversal(int[] inOrder, int[] postOrder, int inStart, int inEnd) {

        if(inStart > inEnd)
            return null;

        TreeNode node = new TreeNode(postOrder[Post_order_index--]);

        if(inStart == inEnd)
            return node;

        int rootIndexInInorder = search(inOrder,node.getData(), inStart, inEnd);

        node.setRight(constructTreeFromInAndPostOrderTraversal(inOrder,postOrder,rootIndexInInorder+1,inEnd));

        node.setLeft(constructTreeFromInAndPostOrderTraversal(inOrder,postOrder,inStart,rootIndexInInorder-1));

        return node;
    }

    private static int search(int[] inOrder, int data, int inStart, int inEnd) {

        int i = inEnd;

        for(; i >=0; i--) {
            if(inOrder[i] == data) {
                break;
            }
        }

        return i;
    }
}
