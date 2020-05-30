package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.Arrays;
import java.util.List;

public class CheckIfPathExistsInBT {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(62,40,42,39);
        TreeNode root = DSUtils.getPerfectBinaryTree3Levels().getRoot();

        boolean status = checkIfPathExistsInBT(root, list, 0);
        System.out.print("Path exists : " + status);
    }

    public static boolean checkIfPathExistsInBT(TreeNode root, List<Integer> list, int level) {

        if(root == null || level > list.size()-2)
            return true;

        if(root.getData() != list.get(level))
            return false;

        if(root.getLeft() != null && root.getLeft().getData() == list.get(level + 1))
            root = root.getLeft();
        else if(root.getRight() != null && root.getRight().getData() == list.get(level + 1))
            root = root.getRight();
        else
            return false;

        return checkIfPathExistsInBT(root, list, level+1);
    }
}
