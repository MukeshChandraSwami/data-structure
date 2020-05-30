package tree.binary.checking_and_printing;


import tree.binary.common.TreeNode;
import utils.DSUtils;

/**
 * Mirror of itself.
 */
public class CheckForSymmetricBT {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getSymmetricBinaryTree().getRoot();

        boolean status = checkIfSymmetricBT(root, root);
        System.out.print("Symmetric Tree : " + status);
    }

    public static boolean checkIfSymmetricBT(TreeNode l, TreeNode r) {

        if(l == null && r == null)
            return true;

        if(l == null || r == null)
            return true;

        return l.getData() == r.getData()
                && checkIfSymmetricBT(l.getLeft(), r.getRight())
                && checkIfSymmetricBT(l.getRight(), r.getLeft());
    }
}
