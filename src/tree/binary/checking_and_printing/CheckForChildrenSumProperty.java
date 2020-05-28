package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 */
public class CheckForChildrenSumProperty {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getPerfectBinaryTree2Levels().getRoot();

        boolean status = checkForChildrenSumPropertyUsingQueue(root);
        System.out.print("Sum property status [Queue] : " + status);

        status = checkForChildrenSumPropertyUsingRecursion(root);
        System.out.print("\n\nSum property status [Recursion] : " + status);
    }

    public static boolean checkForChildrenSumPropertyUsingQueue(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.remove();

            int left = 0;
            int right = 0;

            if(node.getLeft() == null && node.getRight() == null)
                continue;

            if(node.getLeft() != null) {
                left = node.getLeft().getData();
                q.add(node.getLeft());
            }

            if(node.getRight() != null) {
                right = node.getRight().getData();
                q.add(node.getRight());
            }

            if(node.getData() != (left + right))
                return false;
        }

        return true;
    }


    public static boolean checkForChildrenSumPropertyUsingRecursion(TreeNode root) {

        if(root == null || (root.getLeft() == null && root.getRight() == null))
            return true;

        int l = 0;
        int r = 0;

        if(root.getLeft() != null)
            l = root.getLeft().getData();

        if(root.getRight() != null)
            r = root.getRight().getData();

        boolean ls = checkForChildrenSumPropertyUsingRecursion(root.getLeft());
        boolean rs = checkForChildrenSumPropertyUsingRecursion(root.getRight());

        return ((l + r) == root.getData())
                && ls && rs;
    }
}
