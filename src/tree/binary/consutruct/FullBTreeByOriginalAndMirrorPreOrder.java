package tree.binary.consutruct;


import utils.DSUtils;

/**
 * Reverse of PRE_ORDER_MIRROR is same as POST_ORDER traversal.
 * So we can construct it using PRE_ORDER and POST_ORDER traversal.
 */
public class FullBTreeByOriginalAndMirrorPreOrder {

    private static int PRE[] = {1,2,4,5,3,6,7};
    private static int PRE_MIRROR[] = {1,3,7,6,2,5,4};

    public static void main(String[] args) {

        int post[] = DSUtils.reverse(PRE_MIRROR);

        //TreeFromInAndPost.constructTreeFromInAndPostOrderTraversal()
    }
}
