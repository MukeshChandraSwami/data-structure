package tree.rb;

import tree.binary.common.TreeNode;
import tree.common.RotationType;
import tree.common.Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree {

    private TreeNode root;

    public RedBlackTree() {}

    public RedBlackTree(int data) {
        this.root = new TreeNode(data);
    }

    public boolean search(int data) {

        return search(this.root, data) != null;
    }

    public void insert(int data) {
        if(this.root == null) {
            this.root = new TreeNode(data, TreeNode.Color.BLACK);
            return;
        }
        this.insert(this.root, data);
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

    private void preOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.print("\t" + root.getData() + " : " + root.getColor().getName() + "\t|");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.getLeft());
        System.out.print("\t" + root.getData() + " : " + root.getColor().getName() + "\t|");
        inOrder(root.getRight());
    }

    private void postOrder(TreeNode root) {
        if (root == null)
            return;

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print("\t" + root.getData() + " : " + root.getColor().getName() + "\t|");
    }

    private void levelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.remove();

            System.out.print("\t" + node.getData() + " : " + root.getColor().getName() + "\t|");
            if (node.getLeft() != null)
                q.add(node.getLeft());
            if (node.getRight() != null)
                q.add(node.getRight());
        }
    }

    private void insert(TreeNode root, int data) {

        TreeNode newNode = null;
        while(true) {
            if(data < root.getData()) {
                if(root.getLeft() == null) {
                    newNode = new TreeNode(data);
                    root.setLeft(newNode.setParent(root));
                    break;
                }
                root = root.getLeft();
            } else if(data > root.getData()) {
                if(root.getRight() == null) {
                    newNode = new TreeNode(data);
                    root.setRight(newNode.setParent(root));
                    break;
                }
                root = root.getRight();
            }
        }

        if(newNode !=  null
                && newNode.getParent() != null
                && newNode.getParent().getColor() != TreeNode.Color.BLACK) {
            fixAfterInsertion(newNode);
        }
    }

    private void fixAfterInsertion(TreeNode node) {
        TreeNode parent = node.getParent();
        while(node.getParent() != null
                && node.getParent().getColor() == TreeNode.Color.RED) {
            TreeNode sibling = getSibling(parent);
            if(sibling != null && sibling.getColor() == TreeNode.Color.RED) {
                reColor(parent);
                reColor(sibling);
                if(parent.getParent() != this.root)
                    reColor(parent.getParent());
            } else {
                RotationType rotationType = getRotationType(node);
                switch (rotationType) {
                    case LL:
                        rightRotate(node.getParent().getParent());
                        break;
                    case RR:
                        leftRotate(node.getParent().getParent());
                        break;
                    case LR:
                        node.getParent().getParent().setLeft(leftRotate(node.getParent()));
                        rightRotate(node.getParent().getParent());
                        break;
                    case RL:
                        node.getParent().getParent().setRight(rightRotate(node.getParent()));
                        leftRotate(node.getParent().getParent());
                        break;
                }
            }
            node = node.getParent();
        }
    }

    private TreeNode leftRotate(TreeNode node) {
        TreeNode superParent = node.getParent();
        TreeNode rChild = node.getRight();
        TreeNode rlChild = rChild.getLeft();

        if(node == this.root) {
            this.root = rChild;
        }

        node.setRight(rlChild != null ? rlChild.setParent(node) : rlChild);
        rChild.setLeft(node.setParent(rChild));

        reColor(rChild);
        reColor(node);

        return rChild.setParent(superParent);
    }

    private TreeNode rightRotate(TreeNode node) {
        TreeNode superParent = node.getParent();
        TreeNode lChild = node.getLeft();
        TreeNode lrChild = lChild.getRight();

        if(node == this.root) {
            this.root = lChild;
        }

        node.setLeft(lrChild != null ? lrChild.setParent(node) : lrChild);
        lChild.setRight(node.setParent(lChild));

        reColor(node);
        reColor(lChild);

        return lChild.setParent(superParent);
    }

    private void reColor(TreeNode node) {
        if(node.getColor() == TreeNode.Color.RED) {
            node.setColor(TreeNode.Color.BLACK);
        } else {
            node.setColor(TreeNode.Color.RED);
        }
    }

    private TreeNode getSibling(TreeNode node) {
        return node.getParent().getData() < node.getData()
                ? node.getParent().getLeft()
                : node.getParent().getRight();
    }

    private RotationType getRotationType(TreeNode node) {

        String s = "";
        TreeNode parent = node.getParent();
        TreeNode grandParent = parent.getParent();
        if(grandParent.getLeft() != null && grandParent.getLeft() == parent) {
            s += "L";
        } else {
            s += "R";
        }
        if(parent.getLeft() != null && parent.getLeft() == node) {
            s += "L";
        } else {
            s += "R";
        }

        return getRotationType(s);
    }

    private RotationType getRotationType(String s) {
        RotationType  type = null;
        switch (s) {
            case "LL":
                type = RotationType.LL;
                break;
            case "RR":
                type = RotationType.RR;
                break;
            case "LR":
                type = RotationType.LR;
                break;
            case "RL":
                type = RotationType.RL;
                break;
        }
        return type;
    }
}
