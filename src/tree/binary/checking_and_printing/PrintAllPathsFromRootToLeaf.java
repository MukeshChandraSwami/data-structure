package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.HashSet;
import java.util.Set;

public class PrintAllPathsFromRootToLeaf {

    public static void main(String[] args) {

        Set<String> allPaths = getAllPathsFromRootToLeaves(DSUtils.getTreeWithSmallNumbers().getRoot(), "", new HashSet<>());
        System.out.print("All paths : ");
        allPaths.forEach(s -> System.out.println(s.substring(0, s.length() - 2)));
    }

    public static Set<String> getAllPathsFromRootToLeaves(TreeNode root,String s, Set<String> list) {

        if(root == null) {
            return list;
        }

        if(root.getLeft() == null && root.getRight() == null) {
            list.add(s + root.getData() + "->");
        }

        s += root.getData() + "->";

        getAllPathsFromRootToLeaves(root.getLeft(), s, list);
        getAllPathsFromRootToLeaves(root.getRight(), s, list);

        return list;
    }
}
