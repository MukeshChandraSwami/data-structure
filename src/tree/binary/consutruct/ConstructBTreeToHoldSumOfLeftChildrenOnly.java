package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.LevelOrderTraversal;
import utils.DSUtils;

public class ConstructBTreeToHoldSumOfLeftChildrenOnly {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getTreeWithSmallNumbers().getRoot();
        createBTToHoldSumOfLeftChildren(root);
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    public static int createBTToHoldSumOfLeftChildren(TreeNode node) {

        if(node == null)
            return 0;

        if(node.getLeft() == null && node.getRight() == null)
            return node.getData();

        int l = createBTToHoldSumOfLeftChildren(node.getLeft());
        int r = createBTToHoldSumOfLeftChildren(node.getRight());

        node.setData(node.getData() + l);

        return node.getData() + r;
    }
}
