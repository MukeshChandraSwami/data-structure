package tree.bst.construction.and.conversion;

import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortedLIstToBST {

    public static void main(String[] args) {

        List<Integer> list = IntStream.range(0, 13)
                .distinct()
                .boxed()
                .collect(Collectors.toList());

        TreeNode root = constructBST(list, 0, list.size() - 1);
        TraverseWithoutRecursion.inOrderTraversal1(root);
    }

    public static TreeNode constructBST(List<Integer> list, int start, int end) {

        if(start > end)
            return null;

        int mid = getMid(list, start, end);
        TreeNode node = new TreeNode(list.get(mid));

        node.setLeft(constructBST(list, start, mid - 1));

        node.setRight(constructBST(list, mid + 1, end));

        return node;
    }

    private static int getMid(List<Integer> list, int start, int end) {
        return (int)Math.floor((start + end) / 2);
    }
}
