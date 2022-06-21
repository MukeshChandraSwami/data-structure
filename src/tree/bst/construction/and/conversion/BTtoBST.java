package tree.bst.construction.and.conversion;

import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;
import utils.DSUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTtoBST {

    public static void main(String[] args) {

        TreeNode root = convertFromBTtoBST(DSUtils.getTree().getRoot());
        System.out.print("In order traversal before :");
        TraverseWithoutRecursion.inOrderTraversal1(DSUtils.getTree().getRoot());

        System.out.print("\n\nIn order traversal after :");
        TraverseWithoutRecursion.inOrderTraversal1(root);
    }

    //[39, 40, 42, 55, 62, 70, 79, 84, 91]

    public static TreeNode convertFromBTtoBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        getInOrderArray(root, list);

        List<Integer> original = (List<Integer>) ((ArrayList<Integer>) list).clone();
        Collections.sort(list);

        TreeNode node = new TreeNode(list.get(findIndexOfItem(root, original)));

        constructTree(root, node, list, original);

        return node;
    }

    private static void constructTree(TreeNode root, TreeNode node, List<Integer> list, List<Integer> original) {

        if(root == null)
            return;

        if(root.getLeft() != null) {
            int index = findIndexOfItem(root.getLeft(), original);
            TreeNode n = new TreeNode(list.get(index));
            node.setLeft(n);

            constructTree(root.getLeft(), node.getLeft(), list, original);
        }

        if(root.getRight() != null) {
            int index = findIndexOfItem(root.getRight(), original);
            TreeNode n = new TreeNode(list.get(index));
            node.setRight(n);

            constructTree(root.getRight(), node.getRight(), list, original);
        }

    }

    private static void getInOrderArray(TreeNode root, List<Integer> list) {

        if(root == null)
            return;

        getInOrderArray(root.getLeft(),list);
        list.add(root.getData());
        getInOrderArray(root.getRight(), list);
    }

    private static int findIndexOfItem(TreeNode root, List<Integer> list) {

        for(int i = 0; i < list.size(); i++) {

            if(root.getData() == list.get(i))
                return i;
        }

        return 0;
    }
}
