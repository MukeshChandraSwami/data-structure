package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConstructDoublyLLFromTernaryTree {

    public static void main(String[] args) {

        TreeNode tree = DSUtils.getTernaryTree();

        List<Integer> list = createListFromTree(tree);

        System.out.println(list);
    }

    private static List<Integer> createListFromTree(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        List<Integer> l = new ArrayList<>();

        while(!stack.isEmpty()) {
            TreeNode poppedNode = stack.pop();

            if(poppedNode.getRight() != null)
                stack.push(poppedNode.getRight());
            if(poppedNode.getMiddle() != null)
                stack.push(poppedNode.getMiddle());
            if(poppedNode.getLeft() != null)
                stack.push(poppedNode.getLeft());

            l.add(poppedNode.getData());
        }

        return l;
    }
}
