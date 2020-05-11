package tree.binary.traversal;

import tree.binary.Tree;
import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Step 1 : Get an empty queue and push root and its all right nodes in it.
 * Step 2 : Loop while queue is not empty
 *      2.1 : Remove an item from queue.
 *      2.2 : Manipulate this item.
 *      2.3 : Insert left of this removed item.
 *      2.4 : Insert all right of that left like step 1.
 */
public class TraverseDiagonally {

    public static void main(String[] args) {

        Tree tree = DSUtils.getPerfectBinaryTree();
        System.out.print("Print diagonally via queue : ");
        printDiagonally(tree.getRoot());
    }

    public static void printDiagonally(TreeNode root) {

        TreeNode temp = root;
        Queue<TreeNode> queue = new LinkedList<>();

        while(temp != null) {
            queue.add(temp);
            temp = temp.getRight();
        }

        while(!queue.isEmpty()) {

            TreeNode node = queue.remove();
            System.out.print("\t" + node.getData() + "\t|");

            TreeNode left = node.getLeft();
            if(left != null) {
                queue.add(left);
                TreeNode right = left.getRight();
                while(right != null) {
                    queue.add(right);
                    right = right.getRight();
                }
            }
        }
    }
}
