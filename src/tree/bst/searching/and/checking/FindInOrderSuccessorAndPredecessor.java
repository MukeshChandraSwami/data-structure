package tree.bst.searching.and.checking;

import tree.binary.common.Holder;
import tree.binary.common.TreeNode;
import utils.DSUtils;

public class FindInOrderSuccessorAndPredecessor {

    public static void main(String[] args) {

        Holder h = new Holder();
        h.setX(Integer.MAX_VALUE);
        h.setY(Integer.MIN_VALUE);
        getInOrderSuccessor(DSUtils.getBST().getRoot(), new TreeNode(8), h);
        if(h.isFlag()) {
            System.out.print("Inorder Predecessor : " + h.getY());
            System.out.print("\n\nInorder Successor : " + h.getX());
        } else {
            System.out.println("This node is not present");
        }
    }

    public static void getInOrderSuccessor(TreeNode root, TreeNode node, Holder h) {
        if(root == null)
            return;

        if(root.getData() > node.getData()  && root.getData() < h.getX())
            h.setX(root.getData());

        if(root.getData() < node.getData() && root.getData() > h.getY())
            h.setY(root.getData());

        if(root.getData() == node.getData())
            h.setFlag(true);

        if(root.getLeft() != null)
             getInOrderSuccessor(root.getLeft(), node, h);
        else
             getInOrderSuccessor(root.getRight(), node, h);
    }
}
