package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class CheckIf2BTsAreIdentical {

    public static void main(String[] args) {

        TreeNode t1 = DSUtils.getPerfectBinaryTree2Levels().getRoot();
        TreeNode t2 = DSUtils.getMirrorOfPerfectBinaryTree2Levels().getRoot();

        boolean status = checkForIdenticalTrees(t1, t2);
        System.out.print("Identical Trees : " + status);
    }

    public static boolean checkForIdenticalTrees(TreeNode t1, TreeNode t2) {

        if(t1 == null && t2 == null)
            return true;

        if(t1 == null || t2 == null)
            return false;

        return t1.getData() == t2.getData()
                && checkForIdenticalTrees(t1.getLeft(), t2.getLeft())
                && checkForIdenticalTrees(t1.getRight(), t2.getRight());
    }
}
