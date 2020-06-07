package tree.avl;

import tree.binary.common.TreeNode;
import tree.common.Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

    private TreeNode root;

    public AVLTree(int data) {
        this.root = new TreeNode(data);
    }

    public boolean search(int data) {

        return search(this.root, data) != null;
    }

    public void insert(int data) {

    }

    public void traverse(Traversal t) {

        switch (t) {
            case PRE_ORDER:
                preOrder(this.root);
                break;
            case IN_ORDER:
                inOrder(this.root);
                break;
            case POST_ORDER:
                postOrder(this.root);
                break;
            case LEVEL_ORDER:
                levelOrder(this.root);
                break;
        }
    }
    private void preOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.print("\t" + root.getData() + "\t|");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.getLeft());
        System.out.print("\t" + root.getData() + "\t|");
        inOrder(root.getRight());
    }

    private void postOrder(TreeNode root) {
        if (root == null)
            return;

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print("\t" + root.getData() + "\t|");
    }

    private void levelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.remove();

            System.out.print("\t" + node.getData() + "\t|");
            if (node.getLeft() != null)
                q.add(node.getLeft());
            if (node.getRight() != null)
                q.add(node.getRight());
        }
    }

    private TreeNode search(TreeNode root, int data) {

        if (root == null || root.getData() == data) {
            return root;
        } else if (data < root.getData()) {
            return search(root.getLeft(), data);
        } else {
            return search(root.getRight(), data);
        }
    }


    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
