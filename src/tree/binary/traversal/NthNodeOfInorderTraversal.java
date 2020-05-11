package tree.binary.traversal;

import tree.binary.Tree;
import tree.binary.common.TreeNode;
import utils.DSUtils;

public class NthNodeOfInorderTraversal {

    static int counter = 0;

    public static void main(String[] args) {
        Tree tree = DSUtils.getTree();

        int n = 3;
        getNthNode(tree.getRoot(), n);
    }

    public static void getNthNode(TreeNode node, int n) {

        if(node == null)
            return;

        if(counter <= n) {
            getNthNode(node.getLeft(), n);
            counter++;
            if (counter == n) {
                System.out.print("Node : " + node.getData());
            }
            getNthNode(node.getRight(), n);
        }
    }
}
