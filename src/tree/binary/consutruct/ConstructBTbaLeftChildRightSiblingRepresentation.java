package tree.binary.consutruct;


import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/creating-tree-left-child-right-sibling-representation/
 * https://www.geeksforgeeks.org/left-child-right-sibling-representation-tree/
 */
public class ConstructBTbaLeftChildRightSiblingRepresentation {

    public static void main(String[] args) {

        TreeNode ternaryTree = DSUtils.getTernaryTree();

        TreeNode root = createBTViaLeftChildRightSiblingsMethod(ternaryTree);
        TraverseWithoutRecursion.preOrderTraversal1(root);
    }

    public static TreeNode createBTViaLeftChildRightSiblingsMethod(TreeNode ternaryTree) {

        Queue<TreeNode> queueParent = new LinkedList<>();
        queueParent.add(ternaryTree);

        Queue<TreeNode> queueChildren = new LinkedList<>();
        TreeNode root = new TreeNode(ternaryTree.getData());

        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);

        while(!queueParent.isEmpty()) {

            TreeNode popped = queueParent.remove();

            if(popped.getLeft() != null) {
                TreeNode left = new TreeNode(popped.getLeft().getData());
                queueParent.add(popped.getLeft());
                queueChildren.add(left);
                tempQueue.add(left);
            }
            if(popped.getMiddle() != null) {
                TreeNode middle = new TreeNode(popped.getMiddle().getData());
                queueParent.add(popped.getMiddle());
                queueChildren.add(middle);
                tempQueue.add(middle);
            }
            if(popped.getRight() != null) {
                TreeNode right = new TreeNode(popped.getRight().getData());
                queueParent.add(popped.getRight());
                queueChildren.add(right);
                tempQueue.add(right);
            }

            TreeNode temp = tempQueue.remove();

            boolean flag = true;
            while(!queueChildren.isEmpty()) {
                if(flag) {
                    temp.setLeft(queueChildren.remove());
                    flag = false;
                }
                else{
                    TreeNode n = temp.getLeft();
                    while(n.getRight() != null) {
                        n = n.getRight();
                    }
                    n.setRight(queueChildren.remove());
                }
            }
        }

        return root;
    }
}
