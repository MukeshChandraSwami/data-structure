package tree.binary.traversal;

import utils.DSUtils;

public class PostFromInAndPre {

    private static int preOrderIndex = 0;

    public static void main(String[] args) {
        getPostOrder(DSUtils.IN_ORDER, DSUtils.PRE_ORDER,0,DSUtils.IN_ORDER.length - 1);
    }

    public static void getPostOrder(int[] inOrder, int[] preOrder, int inOrderStart, int inOrderEnd) {

        if(inOrderStart > inOrderEnd)
            return;

        // Search for root element in In-Order traversal array.
        // First element of Pre-Order is always root.
        int rootIndexInInorder = search(inOrder,preOrder[preOrderIndex++],inOrderStart,inOrderEnd);

        // Now do same in left side.
        getPostOrder(inOrder,preOrder,inOrderStart,rootIndexInInorder-1);

        // Now do same in right side.
        getPostOrder(inOrder,preOrder,rootIndexInInorder+1,inOrderEnd);

        // Print the root node at the end of traversal.
        System.out.print("\t" + inOrder[rootIndexInInorder] + "\t|");
    }

    private static int search(int[] inOrder, int root, int inOrderStart, int inOrderEnd) {
        int i;
        for(i = inOrderStart; i < inOrderEnd; i++)
            if(inOrder[i] == root)
                return i;

        return i;
    }
}
