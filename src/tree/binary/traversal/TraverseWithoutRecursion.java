package tree.binary.traversal;

import tree.binary.Tree;
import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class TraverseWithoutRecursion {

    public static void main(String[] args) {
        Tree tree = DSUtils.getTree();

        System.out.print("Inorder Traversing : ");
        inOrderTraversal3(tree.getRoot());

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
    public static void inOrderTraversal1(TreeNode root) {

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

    public static void inOrderTraversal2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        while (Objects.nonNull(root) || !stack.isEmpty()) {

            while(Objects.nonNull(root)) {
                stack.add(root);
                root = root.getLeft();
            }

            TreeNode popped = stack.pop();
            System.out.print("\t" + popped.getData() + "\t|");
            root = popped.getRight();
        }
    }

    /**
     * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
     * This is Morris Traversal.
     *
     * Algo:-
     * Step 0: Initialize current as root
     * Step 1: While current is not null
     * Step 2: Check if left of current is null or not
     * Step 3: If it is null
     *          1. Print current
     *          2. Set current by right of the current
     * Step 4: If it is not null
     *          1. Get prev as left of current.
     *          2. Go to the right most child of prev OR to the child whose right is equals to current.
     *              a. If it is right most child then set its right as current
     *              b. Set current as left of current.
     *          3. If prev has right as current node then
     *              a. Set right of current as null
     *              b. Print current's data
     *              c. set current as right of the current.
     *
     * @param root
     */
    public static void inOrderTraversal3(TreeNode root) {

        TreeNode current = root;

        while(Objects.nonNull(current)) {

            if(Objects.isNull(current.getLeft())) {
                System.out.print("\t" + current.getData() + "\t|");
                current = current.getRight();
            } else {

                TreeNode pre = current.getLeft();
                while(Objects.nonNull(pre.getRight()) && pre.getRight() != current) {
                    pre = pre.getRight();
                }

                if(Objects.isNull(pre.getRight())) {
                    pre.setRight(current);
                    current = current.getLeft();
                } else {
                    pre.setRight(null);
                    System.out.print("\t" + current.getData() + "\t|");
                    current = current.getRight();
                }
            }
        }
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
    public static List<Integer> preOrderTraversal(TreeNode root) {

        List<Integer> l = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {

            TreeNode popped = stack.pop();
            System.out.print("\t" + popped.getData() + "\t|");
            l.add(popped.getData());

            if(popped.getRight() != null)
                stack.push(popped.getRight());

            if(popped.getLeft() != null)
                stack.push(popped.getLeft());

        }

        return l;
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
