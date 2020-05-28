package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import tree.binary.consutruct.TreeFromInAndPre;
import utils.DSUtils;

import java.util.Stack;

public class CheckInPareAndPostAreBelongsToSameTree {

    public static void main(String[] args) {

        boolean status = check(DSUtils.IN_ORDER, DSUtils.PRE_ORDER, DSUtils.POST_ORDER);

        System.out.print("Inorder, Pre-Order and Post-Order belongs to same tree : " + status);
    }

    public static boolean check(int[] inOrder, int[] preOrder, int[] postOrder) {

        TreeNode root = TreeFromInAndPre.createTree(preOrder, inOrder, 0, inOrder.length - 1);

        Stack<Integer> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s2.push(root);

        while(!s2.isEmpty()) {

            TreeNode popped = s2.pop();
            s1.push(popped.getData());

            if(popped.getLeft() != null)
                s2.push(popped.getLeft());

            if(popped.getRight() != null)
                s2.push(popped.getRight());
        }

        int i = 0;
        while(!s1.isEmpty()) {
            if( s1.pop() != postOrder[i++])
                return false;
        }

        return true;
    }
}
