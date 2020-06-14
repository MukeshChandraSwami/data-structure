package tree.avl;

import tree.binary.common.TreeNode;
import tree.bst.BST;
import tree.common.Traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 */
public class AVLTree {

    private TreeNode root;
    private BST.LookAfterDelete del;

    public AVLTree(int data) {
        this.root = new TreeNode(data);
        this.del = BST.LookAfterDelete.LEFT_SUB_TREE;
    }

    public AVLTree() {
    }

    public boolean search(int data) {

        return search(this.root, data) != null;
    }

    public void insert(int data) {

        if (this.root == null) {
            this.root = new TreeNode(data);
            return;
        }
        insert(this.root, data);
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

    /**
     * @param root
     * @param data
     * @return Step 1 : Insert like BST.
     * Step 2 : Set height of node.
     * Step 3 : Check balance factor.
     * Step 4 : Now check for 4 conditions of unbalanced tree.
     * 4.1 : If LL then do Left Left Rotation.
     * 4.2 : If LR then do Left Right Rotation
     * 4.3 : If RR then do Right Right Rotation.
     * 4.4 : If RL then do Right Left Rotation
     */
    private TreeNode insert(TreeNode root, int data) {

        // Step 1 : Inserting like normal BST.
        if (root == null)
            return new TreeNode(data);

        if (data < root.getData()) {
            root.setLeft(insert(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(insert(root.getRight(), data));
        } else {
            System.out.print("Duplicate keys not allowed.");
            return root;
        }

        // Step 2 : Getting and setting height.
        int height = Math.max(height(root.getLeft()), height(root.getRight())) + 1;
        root.setHeight(height);

        // Step 3 : Getting balance factor
        int bf = balanceFactor(root);

        // Step 4 : Checking for unbalancing of tree.

        // Step 4.1 : Checking for LL balance.
        if (bf > 1 && data < root.getLeft().getData()) {
            // Do RR rotation
            return rightRotate(root);
        }

        // Step 4.2 : Checking for LR balance.
        if (bf > 1 && data > root.getLeft().getData()) {
            // Do LR Rotation

            // Do Left Rotation
            root.setLeft(leftRotate(root.getLeft()));
            //Do Right Rotation
            return rightRotate(root);
        }

        // Step 4.3 : Checking for RR balance.
        if (bf < -1 && data > root.getRight().getData()) {
            // Do LL Rotation
            return leftRotate(root);
        }

        // Step 4.4 : Checking for RL balance.
        if (bf < -1 && data < root.getRight().getData()) {
            // Do RL rotation.

            // Do Right Rotation
            root.setRight(rightRotate(root.getRight()));
            // Do Left Rotation
            return leftRotate(root);
        }
        return root;
    }

    private TreeNode delete(TreeNode root, int data) {
        if (root == null)
            return null;

        if (data < root.getData())
            root.setLeft(delete(root.getLeft(), data));
        else if (data > root.getData())
            root.setRight(delete(root.getRight(), data));
        else {
            if (root.getLeft() == null)
                return root.getRight();
            else if (root.getRight() == null)
                return root.getLeft();

            this.del = root.getLeft() != null ? BST.LookAfterDelete.LEFT_SUB_TREE : BST.LookAfterDelete.RIGHT_SUB_TREE;
            TreeNode newNode = null;
            if (this.del == BST.LookAfterDelete.LEFT_SUB_TREE) {
                newNode = findHigh(root.getLeft());
                root.setData(newNode.getData());
                root.setLeft(delete(root.getLeft(), root.getData()));
            } else {
                newNode = findLow(root.getRight());
                root.setData(newNode.getData());
                root.setRight(delete(root.getRight(), root.getData()));
            }

            if(root == null)
                return root;

            root.setHeight(Math.max(height(root.getLeft()), height(root.getRight())) + 1);
            int bf = balanceFactor(root);

            if(bf > 1 && balanceFactor(root.getLeft()) >= 0)
               return rightRotate(root);

            if(bf > 1 && balanceFactor(root.getLeft()) < 0) {
                root.setLeft(leftRotate(root.getLeft()));
                return rightRotate(root);
            }

            if(bf < -1 && balanceFactor(root.getRight()) <= 0)
                return leftRotate(root);

            if(bf < -1 && balanceFactor(root.getRight()) > 0) {
                root.setRight(rightRotate(root.getRight()));
                return leftRotate(root);
            }
        }
        return root;
    }

    private TreeNode rightRotate(TreeNode node) {

        TreeNode lChild = node.getLeft();
        TreeNode lrChild = lChild.getRight();

        lChild.setRight(node);
        node.setLeft(lrChild);

        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
        lChild.setHeight(Math.max(height(lChild.getLeft()), height(lChild.getRight())) + 1);

        return lChild;
    }

    /**
     * @param node
     * @return Step 1 : Right child of node will be new root, so return it.
     * Step 2 : Node will be left child of new root.
     * Step 3 : Existing left child of new root will be right child of node.
     * Step 4 : Update heights (First update height of child and then parent)
     */
    private TreeNode leftRotate(TreeNode node) {
        TreeNode rChild = node.getRight();
        TreeNode rlChild = rChild.getLeft();

        // Rotating
        rChild.setLeft(node);
        node.setRight(rlChild);

        // Updating heights
        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
        rChild.setHeight(Math.max(height(rChild.getLeft()), height(rChild.getRight())) + 1);

        return rChild;
    }

    private int balanceFactor(TreeNode root) {
        if (root == null)
            return 0;
        return height(root.getLeft()) - height(root.getRight());
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


    private int height(TreeNode n) {
        return n != null ? n.getHeight() : 0;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
