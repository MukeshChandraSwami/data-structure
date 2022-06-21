package tree.binary;

import stack.conversion.Expressions;
import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.Objects;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/expression-tree/
 */
public class ExpressionTree {

    public static void main(String[] args) {

        String exp = Expressions.POSTFIX_EVAL2;

        TreeNode root = createTreeFromExpression(exp);
        printInOrder(root);
        int result = evaluate(root);
        System.out.print(" = " + result);
    }

    public static TreeNode createTreeFromExpression(String exp) {

        Stack<TreeNode> s = new Stack<>();
        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            TreeNode n = new TreeNode(c);
            if(DSUtils.checkIfOperator(c)) {
                n.setRight(s.pop());
                n.setLeft(s.pop());
            }
            s.push(n);
        }

        return s.pop();
    }

    private static int evaluate(TreeNode root) {
        if(Objects.isNull(root)) {
            return 0;
        }

        if(Objects.isNull(root.getLeft()) && Objects.isNull(root.getRight())) {
            return Integer.parseInt("" +(char)root.getData());
        }

        int left = evaluate(root.getLeft());
        int right = evaluate(root.getRight());

        return DSUtils.performOperation(left, right, (char)root.getData());
    }

    private static void printInOrder(TreeNode root) {
        if(Objects.isNull(root)) {
            return;
        }

        printInOrder(root.getLeft());
        System.out.print((char)root.getData() + " ");
        printInOrder(root.getRight());
    }
}
