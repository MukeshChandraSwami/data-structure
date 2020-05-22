package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.LevelOrderTraversal;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBTFromList {

    public static void main(String[] args) {
        Queue<TreeNode> llTree = DSUtils.getLLTree();

        TreeNode node = getCompleteBTree(llTree);
        LevelOrderTraversal.levelOrderTraversal(node);
    }

    public static TreeNode getCompleteBTree(Queue<TreeNode> llTree) {

        TreeNode node = llTree.remove();

        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(node);

        while(!llTree.isEmpty()) {
            TreeNode removed = temp.remove();

            if(!llTree.isEmpty()) {
                TreeNode left = llTree.remove();
                temp.add(left);
                removed.setLeft(left);
            }

            if(!llTree.isEmpty()) {
                TreeNode right = llTree.remove();
                temp.add(right);
                removed.setRight(right);
            }
        }
        return node;
    }
}
