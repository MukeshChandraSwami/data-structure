package tree.binary.traversal;

import tree.binary.Tree;
import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        Tree tree = DSUtils.getTree();

        System.out.print("Level order traversal : ");
        levelOrderTraversal(tree.getRoot());

        System.out.print("\n\nLevel order traversal in spiral form : ");
        levelOrderTraversalInSpiralForm(tree.getRoot());

        System.out.println("\n\nLevel order traversal line by line 1 : ");
        printLevelOrderLineByLine1(tree.getRoot());

        System.out.print("\n\nReverse level order traversal : ");
        reverseLevelOrderTraversalViaStackAndQueue(tree.getRoot());
    }

    /**
     * Algo :
     * Step 1 : Create an empty queue.
     * Step 2 : Enqueue root in this queue.
     * Step 3 : Loop while queue is not empty
     *      3.1 : Dequeue from queue and manipulate.
     *      3.2 : Enqueue left of popped item if not null
     *      3.3 : Enqueue right of popped item if not null.
     * @param root
     */
    public static void levelOrderTraversal(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print("\t" + node.getData() + "\t|");
            if(node.getLeft() != null)
                queue.add(node.getLeft());

            if(node.getRight() != null)
                queue.add(node.getRight());
        }
    }

    public static void levelOrderTraversalInSpiralForm(TreeNode node) {

        Stack<TreeNode> stack1 = new Stack<>();         // Stack 1 will print odd level
        Stack<TreeNode> stack2 = new Stack<>();         // Stack 2 will print even level

        stack1.push(node);

        while(!stack1.isEmpty() || !stack2.isEmpty()) {


            while(!stack1.isEmpty()) {
                TreeNode popped = stack1.pop();
                System.out.print("\t" + popped.getData() + "\t|");

                if(popped.getRight() != null)
                    stack2.push(popped.getRight());

                if(popped.getLeft() != null)
                    stack2.push(popped.getLeft());
            }

            while(!stack2.isEmpty()) {

                TreeNode popped = stack2.pop();
                System.out.print("\t" + popped.getData() + "\t|");

                if(popped.getLeft() != null)
                    stack1.push(popped.getLeft());

                if(popped.getRight() != null)
                    stack1.push(popped.getRight());

            }
        }
    }

    public static void printLevelOrderLineByLine1(TreeNode node) {

        Queue<TreeNode> queue1 = new LinkedList<>();         // Stack 1 will print odd level
        Queue<TreeNode> queue2 = new LinkedList<>();         // Stack 2 will print even level

        queue1.add(node);

        while(!queue1.isEmpty() || !queue2.isEmpty()) {


            while(!queue1.isEmpty()) {
                TreeNode popped = queue1.remove();
                System.out.print("\t" + popped.getData());

                if(popped.getLeft() != null)
                    queue2.add(popped.getLeft());

                if(popped.getRight() != null)
                    queue2.add(popped.getRight());
            }

            System.out.println();

            while(!queue2.isEmpty()) {

                TreeNode popped = queue2.remove();
                System.out.print("\t" + popped.getData());

                if(popped.getLeft() != null)
                    queue1.add(popped.getLeft());

                if(popped.getRight() != null)
                    queue1.add(popped.getRight());
            }
            System.out.println();
        }
    }

    public static void reverseLevelOrderTraversalViaStackAndQueue(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {

            TreeNode removed = queue.remove();
            stack.push(removed);

            if(removed.getLeft() != null)
                queue.add(removed.getLeft());

            if(removed.getRight() != null)
                queue.add(removed.getRight());
        }

        while(!stack.isEmpty()) {
            System.out.print("\t" + stack.pop().getData() + "\t|");
        }
    }
}
