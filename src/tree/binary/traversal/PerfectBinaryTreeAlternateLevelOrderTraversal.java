package tree.binary.traversal;

import tree.binary.Tree;
import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PerfectBinaryTreeAlternateLevelOrderTraversal {

    public static void main(String[] args) {
        Tree tree = DSUtils.getPerfectBinaryTree3Levels();

        System.out.print("Top to bottom : ");
        traverseTopTOBottom(tree.getRoot());

        System.out.print("\n\nBottom to top : ");
        traverseBottomToTop(tree.getRoot());
    }

    public static void traverseTopTOBottom(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        System.out.print("\t" + root.getData() + "\t|");
        queue.add(root.getLeft());
        queue.add(root.getRight());

        while(!queue.isEmpty()) {

            TreeNode node1 = queue.remove();
            TreeNode node2 = queue.remove();

            System.out.print("\t" + node1.getData() + "\t|");
            System.out.print("\t" + node2.getData() + "\t|");

            if(node1.getLeft() != null) {
                queue.add(node1.getLeft());
                queue.add(node2.getRight());
                queue.add(node1.getRight());
                queue.add(node2.getLeft());
            }

        }
    }


    public static void traverseBottomToTop(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        stack.push(root);
        queue.add(root.getLeft());
        queue.add(root.getRight());

        while(!queue.isEmpty()) {

            TreeNode node1 = queue.remove();
            TreeNode node2 = queue.remove();

            stack.push(node2);
            stack.push(node1);

            if(node1.getLeft() != null) {
                queue.add(node1.getRight());
                queue.add(node2.getLeft());

                queue.add(node1.getLeft());
                queue.add(node2.getRight());
            }
        }

        while(!stack.isEmpty()) {
            System.out.print("\t" + stack.pop().getData() + "\t|");
        }
    }
}
