package tree.binary.traversal;

import tree.binary.Tree;
import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.Stack;

public class TraverseWithoutRecursion {

    public static void main(String[] args) {
        Tree tree = DSUtils.getTree();

        System.out.print("Inorder Traversing : ");
        inOrderTraversal(tree.getRoot());

        System.out.print("\n\nPre-order Traversing : ");
        preOrderTraversal(tree.getRoot());

        System.out.print("\n\nPost-order Traversing : ");
        postOrderTraversal(tree.getRoot());
    }

    /**
     * @param root
     * Algo :
     * Step 1 : Create an empty stack.
     * Step 2 : Create a variable (current) to indicate current value.
     * Step 3 : Push the current to stack and set current = current.left
     * Step 4 : If current is NULL and stack is not empty
     *      4.1 : Pop an item from stack
     *      4.2 : Manipulate this item. like printing etc.
     *      4.3 : Set current = popped_item.right and repeat from step 3.
     * Step 5 : If current is NULL and stack is empty then terminate.
     */
    public static void inOrderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

       do {
            if(root != null) {
                stack.push(root);
                root = root.getLeft();
            } else {
                if(!stack.isEmpty()){
                    TreeNode popped = stack.pop();
                    System.out.print("\t" + popped.getData() + "\t|");
                    root = popped.getRight();
                }
            }
        } while(root != null || !stack.isEmpty());
    }

    /**
     * @param root
     * Algo :
     * Step 1 : Create an empty stack and push root in it.
     * Step 2 : Iterate while stack is not empty
     *      2.1 : Pop 1 item from stack and print it.
     *      2.2 : Push right item of popped item if not null.
     *      2.3 : Push left item of popped item if not null.
     */
    public static void preOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {

            TreeNode popped = stack.pop();
            System.out.print("\t" + popped.getData() + "\t|");

            if(popped.getRight() != null)
                stack.push(popped.getRight());

            if(popped.getLeft() != null)
                stack.push(popped.getLeft());

        }
    }

    /**
     * @param root
     * Algo :
     * Step 1 : Take 2 stacks , stack1 and stack2. Now push root in stack1
     * Step 2 : Loop until stack1 is not empty.
     *      2.1 : Pop 1 item from stack1 and push it to stack 2.
     *      2.2 : Push left and right of that popped item in stack1.
     * Step 3 : Now print stack2
     */
    public static void postOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);

        Stack<TreeNode> stack2 = new Stack<>();

        while(!stack1.isEmpty()) {
            TreeNode popped = stack1.pop();
            stack2.push(popped);

            if(popped.getLeft() != null)
                stack1.push(popped.getLeft());

            if(popped.getRight() != null)
                stack1.push(popped.getRight());
        }

        while(!stack2.isEmpty()) {
            System.out.print("\t" + stack2.pop().getData() + "\t|");
        }
    }
}
