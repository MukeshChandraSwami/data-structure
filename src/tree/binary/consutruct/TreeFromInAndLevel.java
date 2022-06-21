package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;
import utils.DSUtils;

/**
 * Create a tree from In-order and Level order traversal of a binary tree.
 *
 * As we all know that first node of the Level Order traversal is always root node of the tree.
 * So we will find it in In order traversal.
 * Check following algo for more explained steps :
 * Algo :
 * Step 1 : Crate root node by using levelOrder[0]
 * Step 2 : Find this in in order traversal. Left sub array is left sub tree and right sub array is right sub tree.
 * Step 3 : Traverse left
 * Step 4 : Traverse right
 */
public class TreeFromInAndLevel {

    public static void main(String[] args) {

        int[] inOrder = DSUtils.IN_ORDER;
        int[] levelOrder = DSUtils.LEVEL_ORDER;
        TreeNode root = createTree(inOrder, levelOrder);

        TraverseWithoutRecursion.preOrderTraversal1(root);
    }

    public static TreeNode createTree(int[] inOrder, int[] levelOrder) {

        TreeNode node = new TreeNode(levelOrder[0]);    // Step 1
        return constructTree(node, inOrder, levelOrder, 0, inOrder.length - 1);
    }

    private static TreeNode constructTree(TreeNode node, int[] inOrder, int[] levelOrder, int inStart, int inEnd) {

        if(inStart > inEnd)
            return null;

        if(inStart == inEnd)
            return new TreeNode(inOrder[inStart]);

        int index = 0;
        boolean found = false;

        // Step 2 : Finding index and left, right part.
        for(int i = 0; i < levelOrder.length; i++) {

            for(int j = inStart; j <= inEnd; j++) {
                if(levelOrder[i] == inOrder[j]) {
                    index = j;
                    found = true;
                    node = new TreeNode(inOrder[j]);
                    break;
                }
            }
            if(found)
                break;
        }

        // Step 3 : Traversing left
        node.setLeft(constructTree(node,inOrder,levelOrder,inStart,index - 1));

        // Step 4 : Traversing right
        node.setRight(constructTree(node,inOrder,levelOrder,index+1, inEnd));

        return node;
    }
}
