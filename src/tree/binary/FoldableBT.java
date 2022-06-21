package tree.binary;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/foldable-binary-trees/
 */
public class FoldableBT {

    public static void main(String[] args) {

        TreeNode l = DSUtils.getContinuousTree().getRoot().getLeft();
        TreeNode r = DSUtils.getContinuousTree().getRoot().getRight();
        boolean status = checkIfFoldableBT(l,r);
        System.out.println("Foldable BT Recursive : " + status);

        status = checkIfFoldableBTIterative(DSUtils.getContinuousTree().getRoot());
        System.out.println("Foldable BT Iterative : " + status);
    }

    public static boolean checkIfFoldableBT(TreeNode l, TreeNode r) {

        if(l == null && r == null)
            return true;

        if(l == null || r ==null)
            return false;

        return checkIfFoldableBT(l.getLeft(), r.getRight()) && checkIfFoldableBT(l.getRight(), r.getLeft());
    }

    public static boolean checkIfFoldableBTIterative(TreeNode node) {

        if(Objects.isNull(node) || (Objects.isNull(node.getLeft())) && Objects.isNull(node.getRight())) {
            return true;
        }

        if(Objects.isNull(node.getLeft()) || Objects.isNull(node.getRight())) {
            return false;
        }



        Queue<TreeNode> q = new LinkedList<>();
        q.add(node.getLeft());
        q.add(node.getRight());

        while (!q.isEmpty()) {

            TreeNode a = q.remove();
            TreeNode b = q.remove();

            if(
                    (Objects.isNull(a.getLeft()) && Objects.nonNull(b.getRight())) ||
                            (Objects.nonNull(a.getLeft()) && Objects.isNull(b.getRight())) ||
                                     (Objects.isNull(a.getRight()) && Objects.nonNull(b.getLeft())) ||
                                            (Objects.nonNull(a.getRight()) && Objects.isNull(b.getLeft()))
            ) {
                return false;
            }

            if(Objects.nonNull(a.getLeft())) {
                q.add(a.getLeft());
                q.add(b.getRight());
            }

            if(Objects.nonNull(a.getRight())) {
                q.add(a.getRight());
                q.add(b.getLeft());
            }
        }

        return true;
    }
}
