package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.LevelOrderTraversal;
import utils.DSUtils;

public class ConstructMirror {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getPerfectBinaryTree().getRoot();

        System.out.print("Level order : ");
        LevelOrderTraversal.levelOrderTraversal(root);

        createMirror(root);

        System.out.print("\n\nMirror Level order : ");
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    public static void createMirror(TreeNode node) {

        if(node == null || (node.getLeft() == null && node.getRight() == null))
            return;

        TreeNode temp = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(temp);

        createMirror(node.getLeft());
        createMirror(node.getRight());
    }
}
