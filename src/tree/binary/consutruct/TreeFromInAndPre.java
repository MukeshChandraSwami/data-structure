package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;
import utils.DSUtils;

public class TreeFromInAndPre {

    private static int preIndex = 0;

    public static void main(String[] args) {

        TreeNode root = createTree(DSUtils.PRE_ORDER, DSUtils.IN_ORDER, 0, DSUtils.IN_ORDER.length - 1);

        System.out.print("Post order traversal of tree : ");
        TraverseWithoutRecursion.postOrderTraversal1(root);
    }

    public static TreeNode createTree(int[] preOrder, int[] inOrder, int inStart, int inEnd) {

        if(inStart > inEnd)
            return null;

        // Create node of the tree.
        TreeNode node = new TreeNode(DSUtils.PRE_ORDER[preIndex++]);

        // If this is last node (Means it do not has any child) then return it.
        if(inStart == inEnd)
            return node;

        // Find root index in In-order traversal.
        int rootIndexInInorder = search(inOrder, node.getData(), inStart, inEnd);

        // Create left tree.
        node.setLeft(createTree(preOrder, inOrder, inStart, rootIndexInInorder-1));

        // Create right tree.
        node.setRight(createTree(preOrder,inOrder,rootIndexInInorder+1,inEnd));

        // Return created node. Finally it will point to root node.
        return node;
    }

    private static int search(int[] inOrder,int data, int inStart, int inEnd) {
        int i = inStart;

        for(; i < inEnd; i++)
            if(inOrder[i] == data)
                break;
        return i;
    }
}
