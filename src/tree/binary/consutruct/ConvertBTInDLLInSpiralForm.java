package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.LevelOrderTraversal;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConvertBTInDLLInSpiralForm {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getPerfectBinaryTree().getRoot();
        System.out.print("Level order : ");
        LevelOrderTraversal.levelOrderTraversal(root);
        Queue<Integer> spiralQueue = getSpiralDLL(root);
        System.out.print("\n\nSpiral list : ");
        while(!spiralQueue.isEmpty()) {
            System.out.print("\t" + spiralQueue.remove() + "\t|");
        }
    }

    private static Queue<Integer> getSpiralDLL(TreeNode root) {
        Queue<Integer> spiral = new LinkedList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        stack1.add(root);
        Stack<TreeNode> stack2 = new Stack<>();

        while(!stack1.isEmpty() || !stack2.isEmpty()) {

            while(!stack1.isEmpty()) {
                TreeNode removed = stack1.pop();
                spiral.add(removed.getData());

                if(removed.getLeft() != null)
                    stack2.push(removed.getLeft());

                if(removed.getRight() != null)
                    stack2.push(removed.getRight());
            }

            while(!stack2.isEmpty()) {
                TreeNode removed = stack2.pop();
                spiral.add(removed.getData());

                if(removed.getRight() != null)
                    stack1.push(removed.getRight());

                if(removed.getLeft() != null)
                    stack1.push(removed.getLeft());
            }
        }

        return spiral;
    }
}
