package tree.bst.construction.and.conversion;

import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;
import utils.DSUtils;

import java.util.Stack;

public class ConstructBSTFromTraversalWithoutInOrder {

    public static void main(String[] args) {
        System.out.print("Construct BST by Pre-Order traversal [Post Order]: ");
        TreeNode root = constructBSTFromPreOrder(DSUtils.PRE_ORDER_BST);
        TraverseWithoutRecursion.postOrderTraversal(root);

        System.out.print("\n\nConstruct BST by Post-Order traversal [Pre Order]: ");
        root = constructBSTFromPostOrder(DSUtils.POST_ORDER_BST);
        TraverseWithoutRecursion.preOrderTraversal(root);

        System.out.print("\n\nConstruct BST by Level-Order traversal [Pre Order]: ");
        root = constructBSTFromLevelOrder(DSUtils.LEVEL_ORDER_BST);
        TraverseWithoutRecursion.preOrderTraversal(root);
    }

    /**
     * @param pre
     * @return
     *
     * https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversal-set-2/
     */
    public static TreeNode constructBSTFromPreOrder(int[] pre) {

        // Step 1 : Create root element by first element of pre-order.
        TreeNode root = new TreeNode(pre[0]);

        // Step 2 : Create a stack and push root in it.
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // Step 3 : Iterate through array.
        for(int i = 1; i < pre.length; i++) {

            TreeNode node = null;

            // Step 4 : Pop stack until stack is empty and top of stack is lesser then pre[i]
            while(!stack.isEmpty() && pre[i] > stack.peek().getData()) {
                node = stack.pop();
            }

            TreeNode n = new TreeNode(pre[i]);

            // Step 5 : If no item found in step 4 then set pre[i] as left of peek of stack and push in stack else as right and push in stack
            if(node == null) {
                node = stack.peek();
                node.setLeft(n);
            } else {
                node.setRight(n);
            }
            stack.push(n);
        }
        return root;
    }

    public static TreeNode constructBSTFromPostOrder(int[] post) {

        TreeNode root = new TreeNode(post[post.length-1]);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for(int i = post.length - 2; i >= 0; i--) {

            TreeNode node = null;
            while(!stack.isEmpty() && post[i] < stack.peek().getData()) {
                node = stack.pop();
            }

            TreeNode n = new TreeNode(post[i]);

            if(node == null) {
                node = stack.peek();
                node.setRight(n);
            } else {
                node.setLeft(n);
            }

            stack.push(n);
        }

        return root;
    }

    public static TreeNode constructBSTFromLevelOrder(int[] level) {

        TreeNode root = new TreeNode(level[0]);

        for(int i = 1; i < level.length; i++) {
            TreeNode node = constructBSTFromLevelOrder(root, level[i]);
            if(level[i] <= node.getData())
                node.setLeft(new TreeNode(level[i]));
            else
                node.setRight(new TreeNode(level[i]));
        }

        return root;
    }

    private static TreeNode constructBSTFromLevelOrder(TreeNode root, int i) {

        if(root.getLeft() == null && root.getRight() == null)
            return root;

        if(i < root.getData())
           return root.getLeft() != null ? constructBSTFromLevelOrder(root.getLeft(), i) : root;
        else
           return root.getRight() != null ? constructBSTFromLevelOrder(root.getRight(), i) : root;

    }
}
