package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;

public class PrintCousinsOfNode {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getPerfectBinaryTree3Levels().getRoot();
        int i = 31;
        Queue<TreeNode> cousins = findCousins(root, i);

        if(!cousins.isEmpty()) {
            System.out.print("Cousins of " + i + " : ");
            cousins.forEach(node -> System.out.print("\t" + node.getData() + "\t|"));
        } else {
            System.out.print("No cousins");
        }
    }

    private static Queue<TreeNode> findCousins(TreeNode root, int i) {

        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root.getLeft());
        q1.add(root.getRight());

        Queue<TreeNode> q2 = new LinkedList<>();

        boolean done = false;

        while(!q1.isEmpty() || !q2.isEmpty()) {

            while(!q1.isEmpty()) {

                TreeNode node = q1.remove();

                if((node.getLeft() != null && node.getLeft().getData() == i)
                        || (node.getRight() != null && node.getRight().getData() == i)) {
                    done = true;
                    continue;
                }

                if(node.getLeft() != null)
                    q2.add(node.getLeft());

                if(node.getRight() != null)
                    q2.add(node.getRight());
            }

            if(done)
                return q2;

            while(!q2.isEmpty()) {

                TreeNode node = q2.remove();

                if((node.getLeft() != null && node.getLeft().getData() == i)
                        || (node.getRight() != null && node.getRight().getData() == i)) {
                    done = true;
                    continue;
                }

                if(node.getLeft() != null)
                    q1.add(node.getLeft());

                if(node.getRight() != null)
                    q1.add(node.getRight());
            }

            if(done)
                return q1;
        }

        return new LinkedList<>();
    }
}
