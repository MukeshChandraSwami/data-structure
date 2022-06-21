package tree.bst.construction.and.conversion;

import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;
import utils.DSUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/convert-bst-min-heap/
 * https://www.geeksforgeeks.org/in-place-convert-bst-into-a-min-heap/
 */
public class BSTtoMinHeap {

    private static int index = 0;

    public static void main(String[] args) {
        TreeNode root = DSUtils.getBST().getRoot();
        System.out.print("In order before conversion : ");
        TraverseWithoutRecursion.inOrderTraversal1(root);
        convertUsingList(root);

        System.out.print("\n\nIn order after conversion [Using List] : ");
        TraverseWithoutRecursion.inOrderTraversal1(root);

        System.out.print("\n\nIn order after conversion [Using recursion]");
    }

    public static void convertUsingList(TreeNode root) {

        List<Integer> ls = new ArrayList<>();
        inOrder(root, ls);

        convertUsingList(root, ls);
    }

    private static void inOrder(TreeNode root, List<Integer> ls) {
        if(root == null)
            return;

        inOrder(root.getLeft(), ls);
        ls.add(root.getData());
        inOrder(root.getRight(), ls);
    }

    private static void convertUsingList(TreeNode root, List<Integer> ls) {

        if(root == null)
            return;

        root.setData(ls.get(index++));

        if(root.getLeft() != null) {
            convertUsingList(root.getLeft(), ls);
        }

        if(root.getRight() != null) {
            convertUsingList(root.getRight(), ls);
        }
    }
}
