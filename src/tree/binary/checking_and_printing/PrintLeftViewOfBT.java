package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class PrintLeftViewOfBT {

    public static void main(String[] args) {

        printLeftView(DSUtils.getPerfectBinaryTree3Levels().getRoot());
    }

    public static void printLeftView(TreeNode root) {

        if(root == null)
            return;

        if(root.getLeft() != null) {
            System.out.print("\t" + root.getLeft().getData() + "\t|");
        }

        printLeftView(root.getLeft());
        printLeftView(root.getRight());
    }
}
