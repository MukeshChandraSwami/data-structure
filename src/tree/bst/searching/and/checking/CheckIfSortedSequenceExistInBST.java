package tree.bst.searching.and.checking;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.ArrayList;

public class CheckIfSortedSequenceExistInBST {

    private static int index = 0;
    public static void main(String[] args) {
        boolean status = checkRecursivalyIfSortedSequenceExistsInBST(DSUtils.getBST().getRoot(),new ArrayList<Integer>(){
            {
                add(6); add(9); add(10);add(15);add(18);
            }
        });

        System.out.print("Sorted sequence exists in BST [Recursion] : " + status);
    }

    public static boolean checkRecursivalyIfSortedSequenceExistsInBST(TreeNode root, ArrayList<Integer> list) {
        return checkRecursivaly(root, list) && index >= list.size();
    }

    private static boolean checkRecursivaly(TreeNode root, ArrayList<Integer> list) {

        if(root == null || index >= list.size())
            return true;

        boolean l = true;
        boolean r = true;

        if(root.getLeft() != null)
            l = checkRecursivaly(root.getLeft(), list);
        if(index < list.size()) {
            if (root.getData() > list.get(index)) {
                return false;
            } else if (root.getData() == list.get(index)) {
                ++index;
            }
        }

        if(root.getRight() != null)
            r = checkRecursivaly(root.getRight(), list);

        return l && r;
    }
}
