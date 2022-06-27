package tree.binary.traversal;


import tree.binary.Tree;
import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Idea is to travers all nodes one by one and find path of appropriate node.
 * Step 1 : Create an empty stack who contains path to the node.
 * Step 2 : Create an empty list who is responsible to hold traversed nodes.
 * Step 3 : Add root in stack and loop until stack is empty.
 *      3.1 : Get peek of the stack.
 *      3.2 : break loop if peek is desired node
 *      3.3 : IF left of peek is not null and traversed then push in stack
 *      3.4 : ELSE
 *          3.4.1 : IF right of peek is not null and traversed then push in stack
 *          3.4.2 : ELSE pop 1 item from stack and add in list as traversed item.
 */
public class PathOfNode {

    public static void main(String[] args) {

        Tree tree = DSUtils.getTree();
        int data = 84;

        Stack<TreeNode> stack = getPath(tree.getRoot(), data);
        while(!stack.isEmpty())
            System.out.println(stack.pop().getData());

        stack = new Stack<>();
        System.out.println("\n");
        boolean present = getPath(tree.getRoot(), stack, data);
        if(present) {
            while(!stack.isEmpty())
                System.out.println(stack.pop().getData());
        }
    }

    public static boolean getPath(TreeNode root, Stack<TreeNode> path, int data) {

        // If root is null means data is not available on that particular path. So return false from here.
        if(Objects.isNull(root)) {
            return false;
        }

        // Insert root in stack.
        path.push(root);

        // Return true as soon as data is found.
        if(root.getData() == data) {
            return true;
        }

        // Traverse left and right. This will terminate itself once it gets true from any side.
        if(getPath(root.getLeft(), path, data) || getPath(root.getRight(), path, data)) {
            return true;
        }

        // If contort reached here, it means current top element is not in the path. So pop it out and return false.
        path.pop();

        return false;
    }

    public static Stack<TreeNode> getPath(TreeNode root, int data) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        findPath(data, stack);
        return stack;
    }

    private static void findPath(int data, Stack<TreeNode> stack) {

        List<TreeNode> list = new ArrayList<>();
        while(!stack.isEmpty()) {

            TreeNode peek = stack.peek();

            if (stack.peek().getData() == data)
                break;

            if(peek.getLeft() != null && !list.contains(peek.getLeft())) {
                stack.push(peek.getLeft());
            } else {
                if(peek.getRight() != null && !list.contains(peek.getRight())){
                    stack.push(peek.getRight());
                } else {
                    list.add(stack.pop());
                }
            }
        }
    }
}
