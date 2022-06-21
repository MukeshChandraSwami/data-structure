package tree.binary.checking_and_printing;

import tree.binary.Tree;
import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;
import utils.DSUtils;

import java.util.List;

public class CheckIfBTisSubBTofAnotherBT {

    public static void main(String[] args) {

        TreeNode tree1 = DSUtils.getPerfectBinaryTree3Levels().getRoot();
        TreeNode tree2 = DSUtils.leftTree(new Tree(62)).getRoot();

        boolean status = checkIfSubTree(tree1, tree2);
        System.out.print("\n\nSub tree : " + status);
    }

    public static boolean checkIfSubTree(TreeNode tree1, TreeNode tree2) {

        System.out.print("First Tree : ");
        List<Integer> traversal1 = TraverseWithoutRecursion.preOrderTraversal1(tree1);
        System.out.print("\n\nSecond Tree : ");
        List<Integer> traversal2 = TraverseWithoutRecursion.preOrderTraversal1(tree2);
        return traversal1.containsAll(traversal2);
    }
}
