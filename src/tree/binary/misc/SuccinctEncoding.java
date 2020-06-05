package tree.binary.misc;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/succinct-encoding-of-binary-tree/
 */
public class SuccinctEncoding {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getTree().getRoot();
        List<Integer> ls = new ArrayList<>();
        getSuccinctEncoding(root,ls);
        System.out.println(ls);
    }

    public static void getSuccinctEncoding(TreeNode root, List<Integer> ls) {

        if(root == null) {
            ls.add(0);
            return;
        }

        ls.add(1);
        getSuccinctEncoding(root.getLeft(), ls);
        getSuccinctEncoding(root.getRight(), ls);
    }
}
