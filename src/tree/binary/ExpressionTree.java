package tree.binary;

import stack.conversion.Expressions;
import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/expression-tree/
 */
public class ExpressionTree {

    public static void main(String[] args) {

        String exp = Expressions.INFIX21;

        TreeNode root = createTreeFromExpression(exp);
    }

    public static TreeNode createTreeFromExpression(String exp) {

        Stack<TreeNode> s = new Stack<>();

        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if(DSUtils.checkIfOperator(c)) {

            } else{

                if(c == '(' || c == ')')
                    continue;
                s.push(new TreeNode(Integer.parseInt(""+ c)));
            }
        }

        return s.pop();
    }
}
