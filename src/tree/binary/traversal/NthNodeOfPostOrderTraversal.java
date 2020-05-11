package tree.binary.traversal;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class NthNodeOfPostOrderTraversal {

    static int counter = 0;
    public static void main(String[] args) {

        int n = 3;
        getNthNode(DSUtils.getTree().getRoot(),n);
    }

    public static void getNthNode(TreeNode root, int n) {

        if(root == null)
            return;

        if(counter <= n) {
            getNthNode(root.getLeft(),n);
            getNthNode(root.getRight(),n);
            counter++;
            if(counter == n) {
                System.out.print("Node : " + root.getData());
            }
        }
    }
}
