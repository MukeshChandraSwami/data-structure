package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import tree.binary.traversal.PathOfNode;
import utils.DSUtils;

import java.util.Stack;

public class PrintPathFromRootToNode {

    public static void main(String[] args) {

        Stack<TreeNode> path = PathOfNode.getPath(DSUtils.getPerfectBinaryTree3Levels().getRoot(), 39);
        path.forEach(node -> System.out.print("\t" + node.getData() + "\t|"));
    }
}
