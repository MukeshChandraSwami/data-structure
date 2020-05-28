package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeToDLL {

    public static void main(String[] args) {

        createDllFromBT(Types.T1);
    }

    private static void createDllFromBT(Types t) {

        Holder holder = new Holder();
        switch (t) {
            case T1:
                set1(DSUtils.getPerfectBinaryTree3Levels().getRoot(), holder);
                System.out.println("Set 1 : " + holder.getQueue());
                break;
            case T2:
                break;
            case T3:
                break;
            case T4:
                break;
        }
    }

    private static void set1(TreeNode node, Holder holder) {

        if(node == null)
            return;

        set1(node.getLeft(),holder);

        holder.getQueue().add(node.getData());

        set1(node.getRight(),holder);
    }

    private static enum Types {

        T1, T2, T3, T4;
    }

    private static class Holder {

        private Queue<Integer> queue;

        public Holder() {
            this.queue = new LinkedList<>();
        }
        public Queue<Integer> getQueue() {
            return queue;
        }
        public void setQueue(Queue<Integer> queue) {
            this.queue = queue;
        }
    }
}
