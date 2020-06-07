package tree.bst.construction.and.conversion;

import tree.binary.common.TreeNode;
import tree.binary.traversal.LevelOrderTraversal;
import utils.DSUtils;

import java.util.ArrayList;
import java.util.List;

public class ReversePath {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getBST().getRoot();
        int key = 12;
        System.out.print("Level order traversal before : ");
        LevelOrderTraversal.levelOrderTraversal(root);

        List<TreeNode> ls = reversePath(root, key);
        for(int i = 0, j = ls.size() - 1; i < j; i++, j--) {
            int temp = ls.get(i).getData();
            ls.get(i).setData(ls.get(j).getData());
            ls.get(j).setData(temp);
        }

        System.out.print("\n\nLevel order traversal after : ");
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    private static List<TreeNode> reversePath(TreeNode root, int key) {
        List<TreeNode> ls = new ArrayList<>();

        reversePath(root, key, ls);

        return ls;
    }

    private static void reversePath(TreeNode root, int key, List<TreeNode> ls) {

        if(root == null) {
            ls.clear();
            return;
        }

        ls.add(root);

        if(root.getData() == key) {
            return;
        }

        if(key < root.getData())
            reversePath(root.getLeft(), key, ls);
        else
            reversePath(root.getRight(), key, ls);
    }
}
