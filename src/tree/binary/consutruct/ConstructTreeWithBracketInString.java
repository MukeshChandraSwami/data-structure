package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/construct-binary-tree-string-bracket-representation/
 */
public class ConstructTreeWithBracketInString {

    public static void main(String[] args) {

        String str = "4(2(3)(1(8(7(6)(10)))))(6(5))";

        TreeNode node = constructTreeFromString(str.toCharArray(), 0, str.length() - 1);
        TraverseWithoutRecursion.preOrderTraversal1(node);
    }

    public static TreeNode constructTreeFromString(char[] ch, int start, int end) {

        if(start > end)
            return null;

        Holder holder = getIndexOfRoot(ch, start, end);
        TreeNode root = new TreeNode(ch[0] - 48);

        root.setLeft(constructTreeFromString(holder.getLeft().toCharArray(), 0, holder.getLeft().length() - 1));

        root.setRight(constructTreeFromString(holder.getRight().toCharArray(),0,holder.getRight().length() - 1));

        return root;
    }

    private static Holder getIndexOfRoot(char[] ch, int start, int end) {
        String left = "";
        String right = "";
        Stack<Character> stack = new Stack<>();

        boolean l = true;

        for(int i = start+1; i <= end; i++) {
            if(ch[i] == ')') {
                stack.pop();
            } else if(ch[i] == '(') {
                stack.push(ch[i]);
            }

            if(!stack.isEmpty()) {
                if(l) {
                    left = left + ch[i];
                } else {
                    right = right + ch[i];
                }
            } else {
                l = false;
            }
        }

        left = !left.isEmpty() ? left.substring(1) : left;
        right = !right.isEmpty() ? right.substring(1) : right;

        return new Holder(left, right);
    }

    private static class Holder{
        public Holder(String left, String right) {
            this.left = left;
            this.right = right;
        }
        private String left;
        private String right;

        public String getLeft() {
            return left;
        }

        public void setLeft(String left) {
            this.left = left;
        }

        public String getRight() {
            return right;
        }

        public void setRight(String right) {
            this.right = right;
        }
    }
}
