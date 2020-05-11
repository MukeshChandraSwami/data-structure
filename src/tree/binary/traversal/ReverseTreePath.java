package tree.binary.traversal;

import tree.binary.Tree;
import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseTreePath {

    public static void main(String[] args) {

        Tree tree = DSUtils.getTree();
        int data = 84;

        Stack<TreeNode> stack = getPath(tree.getRoot(), data);

        TreeNode[] arr = new TreeNode[stack.size()];
        int temp = 0;
        while (!stack.isEmpty()){
            arr[temp] = stack.pop();
            temp++;
        }


        for(int i = 0, j = arr.length-1; i <= j; i++,j--) {
            temp = arr[i].getData();
            arr[i].setData(arr[j].getData());
            arr[j].setData(temp);
        }

        tree.inorder(tree.getRoot());
    }

    public static Stack<TreeNode> getPath(TreeNode root, int data) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        findPath(data, stack);
        return stack;
    }

    private static Stack<TreeNode> findPath(int data, Stack<TreeNode> stack) {

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
        return stack;
    }
}
