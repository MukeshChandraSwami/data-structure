package stack.standardproblems;

import stack.Stack;
import stack.conversion.ExpressionType;
import stack.conversion.Expressions;
import utils.DSUtils;

/**
 * This class will evaluate all kins of expressions.
 */
public class ExpressionEvaluation {

    public static void main(String[] args) {

        String expression = Expressions.PREFIX_EVAL1;
        int result = -1;
        ExpressionType expressionType = DSUtils.checkExpressionType(expression);

        switch (expressionType){
            case INFIX:
                result = evaluateInfixExpression(expression);
                break;
            case PREFIX:
                result = evaluatePrefixExpression(expression);
                break;
            case POSTFIX:
                result = evaluatePostfixExpression(expression);
                break;
        }

        System.out.print("Expression : " + expression);
        System.out.print("\nExpression Type : " + expressionType);
        System.out.print("\nResult : " + result);
    }

    /**
     * @param expression
     * @return
     * Evaluate infix expressions.
     */
    public static int evaluateInfixExpression(String expression) {
        Stack stack = new Stack(expression.length());
        for(int i = 0; i < expression.length(); i++) {

        }
        return stack.pop();
    }

    /**
     * @param expression
     * @return
     * Evaluate prefix expressions
     */
    public static int evaluatePrefixExpression(String expression) {
        Stack stack = new Stack(expression.length());
        for(int i = expression.length() - 1; i >= 0 ; i--) {
            char ch = expression.charAt(i);
            if(!DSUtils.checkIfOperator(ch)) {
                stack.push(Integer.parseInt(String.valueOf(ch)));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                int c = DSUtils.performOperation(a,b,ch);
                stack.push(c);
            }
        }
        return stack.pop();
    }

    /**
     * @param expression
     * @return
     * Evaluate postfix expressions
     */
    public static int evaluatePostfixExpression(String expression) {
        Stack stack = new Stack(expression.length());
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(!DSUtils.checkIfOperator(ch)) {
                stack.push(Integer.parseInt(String.valueOf(ch)));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                int c = DSUtils.performOperation(b,a,ch);
                stack.push(c);
            }
        }
        return stack.pop();
    }
}
