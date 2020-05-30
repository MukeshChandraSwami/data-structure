package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/check-binary-tree-contains-duplicate-subtrees-size-2/
 */
public class CheckForDuplicateBT {

    public static void main(String[] args) {

        boolean status = checkForDuplicateBT(DSUtils.getPerfectBinaryTree3Levels().getRoot(), new HashSet<>());
        System.out.print("Contains duplicate BT : " + status);
    }

    public static boolean checkForDuplicateBT(TreeNode root, Set<String> set) {

        //TODO : Implementation pending.
        return false;
    }
}
