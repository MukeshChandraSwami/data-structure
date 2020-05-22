package tree.binary;

import tree.binary.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    private TreeNode root;

    public Tree(int data) {
        this.root = new TreeNode(data);
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public void insert(int data) {

        TreeNode temp = this.root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(temp);

        while(!queue.isEmpty()) {
            temp = queue.remove();

            if(temp.getLeft() == null) {
                temp.setLeft(new TreeNode(data));
                break;
            } else {
                queue.add(temp.getLeft());
            }

            if(temp.getRight() == null) {
                temp.setRight(new TreeNode(data));
                break;
            } else {
                queue.add(temp.getRight());
            }
        }
    }

    public void inorder(TreeNode start) {
        if(start == null)
            return;
        inorder(start.getLeft());
        System.out.print("\t" + start.getData() + "\t|");
        inorder(start.getRight());
    }

    public void preOrder(TreeNode start) {
        if(start == null)
            return;
        System.out.print("\t" + start.getData() + "\t|");
        preOrder(start.getLeft());
        preOrder(start.getRight());
    }

    public void postOrder(TreeNode start) {

        if(start == null)
            return;
        postOrder(start.getLeft());
        postOrder(start.getRight());
        System.out.print("\t" + start.getData() + "\t|");
    }

    public void levelOrder(TreeNode start) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {

            TreeNode node = queue.remove();

            System.out.print("\t" + node.getData() + "\t|");

            if(node.getLeft() != null)
                queue.add(node.getLeft());

            if(node.getRight() != null)
                queue.add(node.getRight());
        }
    }
}
