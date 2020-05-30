package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIf2TressAreMirror {

    public static void main(String[] args) {

        TreeNode t1 = DSUtils.getPerfectBinaryTree2Levels().getRoot();
        TreeNode t2 = DSUtils.getMirrorOfPerfectBinaryTree2Levels().getRoot();

        boolean status = checkIfMirrorIteratively(t1, t2);
        System.out.print("Is mirror [Iteratively] : " + status);

        status = checkIfMirrorRecursively(t1, t2);
        System.out.print("\n\nIs mirror [Recursively] : " + status);
    }

    public static boolean checkIfMirrorRecursively(TreeNode t1, TreeNode t2) {

        if(t1 ==  null && t2 == null)
            return true;

        if(t1 == null || t2 == null)
            return false;

        return t1.getData() == t2.getData()
                && checkIfMirrorRecursively(t1.getLeft(), t2.getRight())
                && checkIfMirrorRecursively(t1.getRight(), t2.getLeft());
    }

    public static boolean checkIfMirrorIteratively(TreeNode t1, TreeNode t2) {

        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(t1);

        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(t2);

        while(!q1.isEmpty() || !q2.isEmpty()) {

            if(q1.isEmpty() || q2.isEmpty())
                return false;

            TreeNode node1 = q1.remove();
            TreeNode node2 = q2.remove();

            if(node1.getData() != node2.getData())
                return false;

            if(node1.getLeft() != null)
                q1.add(node1.getLeft());

            if(node1.getRight() != null)
                q1.add(node1.getRight());

            if(node2.getRight() != null)
                q2.add(node2.getRight());

            if(node2.getLeft() != null)
                q2.add(node2.getLeft());

        }

        return true;
    }
}
