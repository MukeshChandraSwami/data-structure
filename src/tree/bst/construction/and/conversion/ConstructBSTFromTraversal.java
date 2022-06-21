package tree.bst.construction.and.conversion;

import sorting.SelectionSort;
import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;
import tree.common.TraversalType;
import utils.DSUtils;

public class ConstructBSTFromTraversal {

    private static int PRE_ORDER_INDEX = 0;
    private static int POST_ORDER_INDEX = DSUtils.POST_ORDER_BST.length - 1;

    public static void main(String[] args) {

        System.out.print("Construct BST by Pre-Order traversal [Post Order]: ");
        TreeNode root = constructBSTFromPreOrder(DSUtils.PRE_ORDER_BST);
        TraverseWithoutRecursion.postOrderTraversal1(root);

        System.out.print("\n\nConstruct BST by Post-Order traversal [Pre Order]: ");
        root = constructBSTFromPostOrder(DSUtils.POST_ORDER_BST);
        TraverseWithoutRecursion.preOrderTraversal1(root);

        System.out.print("\n\nConstruct BST by Level-Order traversal [Pre Order]: ");
        root = constructBSTFromLevelOrder(DSUtils.LEVEL_ORDER_BST);
        TraverseWithoutRecursion.preOrderTraversal1(root);
    }

    public static TreeNode constructBSTFromPreOrder(int[] pre) {
        int[] in = SelectionSort.sort(pre.clone());
        return constructBSTFromPreOrder(pre,in,0,pre.length - 1);
    }

    public static TreeNode constructBSTFromPostOrder(int[] post) {
        int[] in = SelectionSort.sort(post.clone());
        return constructBSTFromPostOrder(post, in, 0, post.length - 1);
    }

    public static TreeNode constructBSTFromLevelOrder(int[] level) {
        int[] in = SelectionSort.sort(level.clone());
        return constructBSTFromLevelOrder(level, in, 0, level.length - 1);
    }

    private static TreeNode constructBSTFromPreOrder(int[] pre, int[] in, int inStart, int inEnd) {

        if(inStart > inEnd) {
            return null;
        }

        TreeNode n = new TreeNode(pre[PRE_ORDER_INDEX++]);

        if(inStart == inEnd) {
            return n;
        }

        int i = getRootIndex(in,n.getData(),inStart, inEnd, TraversalType.PRE_ORDER, null);

        n.setLeft(constructBSTFromPreOrder(pre,in,inStart,i - 1));

        n.setRight(constructBSTFromPreOrder(pre,in,i + 1, inEnd));

        return n;
    }

    private static TreeNode constructBSTFromPostOrder(int[] post, int[] in, int inStart, int inEnd) {

        if(inStart > inEnd)
            return null;

        TreeNode n = new TreeNode(post[POST_ORDER_INDEX--]);

        if(inStart == inEnd)
            return n;

        int i = getRootIndex(in, n.getData(), inStart, inEnd, TraversalType.POST_ORDER, null);

        n.setRight(constructBSTFromPostOrder(post, in, i + 1, inEnd));

        n.setLeft(constructBSTFromPostOrder(post, in, inStart, i - 1));

        return n;
    }

    private static TreeNode constructBSTFromLevelOrder(int[] level, int[] in, int inStart, int inEnd) {

        if(inStart > inEnd)
            return null;

        int i = getRootIndex(in,0, inStart, inEnd, TraversalType.LEVEL_ORDER, level);
        TreeNode n = new TreeNode(in[i]);

        n.setLeft(constructBSTFromLevelOrder(level, in, inStart, i - 1));

        n.setRight(constructBSTFromLevelOrder(level, in, i + 1, inEnd));

        return n;
    }

    private static int getRootIndex(int[] in, int data, int inStart, int inEnd, TraversalType type, int[] level) {

        int i = 0;

        switch(type) {
            case PRE_ORDER:
                i = inStart;
                for(; i < inEnd; i++)
                    if(in[i] == data)
                        break;
                break;
            case POST_ORDER:
                i = inEnd;
                for(; i >= 0; i--)
                    if(in[i] == data)
                        break;
                break;
            case LEVEL_ORDER:
                for(int j = 0;j < level.length; j++) {
                    i = inStart;
                    for (; i <= inEnd; i++) {
                        if(level[j] == in[i])
                            return i;
                    }
                }
                break;
        }
        return i;
    }
}
