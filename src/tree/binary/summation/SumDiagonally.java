package tree.binary.summation;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;

public class SumDiagonally {

    public static void main(String[] args) {

        diagonalSum(DSUtils.getPerfectBinaryTree3Levels().getRoot());
    }

    public static void diagonalSum(TreeNode root) {

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        addToQueue(q1, root);

        while(!q1.isEmpty() || !q2.isEmpty()) {

            int sum = 0;
            String s = "";
            while(!q1.isEmpty()) {

                TreeNode node = q1.remove();
                if(node.getLeft() != null) {
                    addToQueue(q2, node.getLeft());
                }
                s = s + node.getData() + " + ";
                sum += node.getData();
            }
            if(!s.isEmpty())
                System.out.print("\n" + s.substring(0,s.length() - 3) + " = " + sum);
            s = "";
            sum = 0;

            while(!q2.isEmpty()) {

                TreeNode node = q2.remove();
                if(node.getLeft() != null) {
                    addToQueue(q1, node.getLeft());
                }
                s = s + node.getData() + " + ";
                sum += node.getData();
            }

            if(!s.isEmpty())
                System.out.print("\n" + s.substring(0,s.length() - 3) + " = " + sum);
        }
    }

    private static void addToQueue(Queue<TreeNode> q, TreeNode root) {
        while(root != null) {
            q.add(root);
            root = root.getRight();
        }
    }
}
