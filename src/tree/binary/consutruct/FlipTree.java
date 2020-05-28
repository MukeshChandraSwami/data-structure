package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.LevelOrderTraversal;
import utils.DSUtils;

public class FlipTree {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getPerfectBinaryTree2Levels().getRoot();

        System.out.print("Level order traversal before flip : ");
        LevelOrderTraversal.levelOrderTraversal(root);

        root = flip(root);

        System.out.print("\n\nLevel order traversal after flip : ");
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    public static TreeNode flip(TreeNode root) {

        if(root == null || (root.getLeft() == null && root.getRight() == null))
            return root;

        TreeNode flippedNode = flip(root.getLeft());

        root.getLeft().setLeft(root.getRight());
        root.getLeft().setRight(root);
        root.setLeft(null);
        root.setRight(null);

        return flippedNode;
    }
}
