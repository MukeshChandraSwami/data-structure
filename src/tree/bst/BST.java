package tree.bst;

import tree.binary.common.TreeNode;
import tree.common.Traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of Binary Search Tree.
 * Left Sub Tree < Root < Right Sub Tree
 */
public class BST {

    private TreeNode root;
    private LookAfterDelete del;

    public BST(int data) {
        this.root = new TreeNode(data);
        this.del = LookAfterDelete.RIGHT_SUB_TREE;
    }

    public enum LookAfterDelete {
        LEFT_SUB_TREE, RIGHT_SUB_TREE;
    }

    public void insert(int data) {

        TreeNode node = insert(this.root, data);
        if (data <= node.getData())
            node.setLeft(new TreeNode(data));
        else
            node.setRight(new TreeNode(data));
    }

    public boolean search(int data) {

        return search(this.root, data) != null;
    }

    public void delete(int data) {

        delete(this.root, data);
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

    private TreeNode search(TreeNode root, int data) {

        if (root == null || root.getData() == data) {
            return root;
        } else if (data < root.getData()) {
            return search(root.getLeft(), data);
        } else {
            return search(root.getRight(), data);
        }
    }

    private TreeNode insert(TreeNode root, int data) {

        if (root.getLeft() == null && root.getRight() == null)
            return root;

        if (data < root.getData()) {
            return root.getLeft() != null ? insert(root.getLeft(), data) : root;
        } else {
            return root.getRight() != null ? insert(root.getRight(), data) : root;
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

    private TreeNode findHigh(TreeNode node) {

        if (node.getLeft() == null && node.getRight() == null)
            return node;
        return findHigh(node.getRight());
    }

    private TreeNode findLow(TreeNode node) {

        if (node.getLeft() == null && node.getRight() == null)
            return node;
        return findLow(node.getLeft());
    }

    private TreeNode delete(TreeNode node, int data) {

        if (node == null) {
            System.out.print(" Invalid key");
            return null;
        } else if (data < node.getData()) {
            node.setLeft(delete(node.getLeft(), data));
        } else if(data > node.getData()) {
            node.setRight(delete(node.getRight(), data));
        } else {
            if (node.getLeft() == null)
                return node.getRight();
            else if (node.getRight() == null)
                return node.getLeft();

            TreeNode newNode = null;

            if (del == LookAfterDelete.LEFT_SUB_TREE) {
                newNode = findHigh(node.getLeft());
                node.setData(newNode.getData());
                node.setLeft(delete(node.getLeft(), node.getData()));
            } else {
                newNode = findLow(node.getRight());
                node.setData(newNode.getData());
                node.setRight(delete(node.getRight(), node.getData()));
            }
        }
        return node;
    }

}
