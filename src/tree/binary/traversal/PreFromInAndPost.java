package tree.binary.traversal;

import stack.Stack;
import utils.DSUtils;

public class PreFromInAndPost {

    private static int postIndex = DSUtils.IN_ORDER.length - 1;
    public static void main(String[] args) {

        Stack stack = new Stack(DSUtils.IN_ORDER.length);
        getPreOrder(DSUtils.IN_ORDER, DSUtils.POST_ORDER, 0, DSUtils.IN_ORDER.length - 1, stack);

        System.out.print("Pre-Order : ");
        stack.traverse();
    }

    public static void getPreOrder(int[] inOrder, int[] postOrder, int inOrderStart, int inOrderEnd, Stack stack) {

        if(inOrderStart > inOrderEnd)
            return;

        // Get index of root element in In-Order array.
        int rootIndexInInorder = search(inOrder, inOrderStart, inOrderEnd,postOrder[postIndex--]);

        // traverse right sub tree
        getPreOrder(inOrder,postOrder,rootIndexInInorder+1, inOrderEnd, stack);

        // Traverse left sub tree
        getPreOrder(inOrder,postOrder,inOrderStart,rootIndexInInorder-1, stack);

        // Push the root from in-order in stack.
        stack.push(inOrder[rootIndexInInorder]);
    }

    private static int search(int[] inOrder, int inOrderStart, int inOrderEnd, int data) {
        int i;
        for(i = inOrderStart; i < inOrderEnd; i++)
            if(inOrder[i] == data)
                return i;

        return i;
    }
}
