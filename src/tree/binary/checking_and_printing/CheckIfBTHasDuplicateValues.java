package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CheckIfBTHasDuplicateValues {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        boolean status = checkForDuplicateValues(DSUtils.getPerfectBinaryTree3Levels().getRoot(), list);
        System.out.print(list);
        System.out.print("\n\nContains duplicate elements : " + status);
    }

    public static boolean checkForDuplicateValues(TreeNode root, List<Integer> list) {

        if(root == null)
            return false;


        if(list.contains(root.getData()))
            return true;

        list.add(root.getData());

        return checkForDuplicateValues(root.getLeft(), list) || checkForDuplicateValues(root.getRight(),list);
    }
}
