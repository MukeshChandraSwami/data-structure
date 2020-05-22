package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;
import utils.DSUtils;

/**
 * Idea is to treat higher element as root.
 * https://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/
 */
public class ConstructBTFromInViaHighAsRoot {

    public static void main(String[] args) {

        int inOrder[] = {1, 5, 10, 40, 30, 15, 28, 20};

        TreeNode root = getBT(inOrder, 0, inOrder.length - 1);
        TraverseWithoutRecursion.preOrderTraversal(root);
    }

    public static TreeNode getBT(int[] inOrder, int inStart, int inEnd) {

        if(inStart > inEnd)
            return null;

        int rootIndex = indexOfHigherElement(inOrder,inStart,inEnd);
        TreeNode node = new TreeNode(inOrder[rootIndex]);

        if(inStart == inEnd)
            return node;

        node.setLeft(getBT(inOrder,inStart,rootIndex-1));

        node.setRight(getBT(inOrder,rootIndex+1,inEnd));

        return node;
    }

    private static int indexOfHigherElement(int[] inOrder, int inStart, int inEnd) {

        int high = inOrder[inStart];
        int index = inStart;
        int i = inStart;
        for(; i <= inEnd; i++) {
            if(inOrder[i] > high) {
                high = inOrder[i];
                index = i;
            }
        }

        return index;
    }
}
