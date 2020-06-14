package tree.bst.searching.and.checking;

import tree.binary.common.Holder;
import tree.binary.common.TreeNode;
import tree.binary.traversal.LevelOrderTraversal;
import utils.DSUtils;

public class AddAllSmallerValueToEveryNode {

    public static void main(String[] args) {

        Holder h = new Holder();
        TreeNode root = DSUtils.getBST().getRoot();
        modify(root, h);
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    public static void modify(TreeNode root, Holder h) {
        if(root == null)
            return;

        modify(root.getLeft(), h);

        int sum = h.getX() + root.getData();
        h.setX(sum);
        root.setData(sum);

        modify(root.getRight(), h);
    }
}
