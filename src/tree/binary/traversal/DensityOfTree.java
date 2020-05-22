package tree.binary.traversal;

import tree.binary.Tree;
import tree.binary.common.TreeNode;
import utils.DSUtils;

/**
 * Density = size / height.
 * Size means total nodes in tree.
 */
public class DensityOfTree {

    private static int size = 0;
    public static void main(String[] args) {

        Tree tree = DSUtils.getTree();
        int height = getHeightAndSize(tree.getRoot());

        System.out.print("Height : " + height);
        System.out.print("\n\nSize : " + size);
        System.out.print("\n\nDensity : " + (float)(size / height));
    }

    public static int getHeightAndSize(TreeNode node) {

        if(node == null)
            return 0;

        int l = getHeightAndSize(node.getLeft());
        int r = getHeightAndSize(node.getRight());

        size=size+1;

        return l > r ? l + 1 : r + 1;
    }
}
