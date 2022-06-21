package tree.binary;

import tree.binary.common.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
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

    public boolean delete(int key) {
        TreeNode n = this.root;

        if(Objects.isNull(n)) {
            throw new RuntimeException("Tree does not exists");
        }

        if(Objects.isNull(n.getLeft()) && Objects.isNull(n.getRight())) {
            if(n.getData() == key) {
                this.root = null;
                return true;
            }
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(n);

        TreeNode keyNode = null;
        TreeNode last = null;
        TreeNode parentOfLastNode = null;
        boolean isLeft = false;
        while(!q.isEmpty()) {

            TreeNode t = q.remove();
            if(t.getData() == key) {
                keyNode = t;
            }

            if(Objects.nonNull(t.getLeft())) {
                q.add(t.getLeft());
                last = t.getLeft();
                isLeft = true;
                parentOfLastNode = t;
            }

            if(Objects.nonNull(t.getRight())) {
                q.add(t.getRight());
                last = t.getRight();
                isLeft = false;
                parentOfLastNode = t;
            }
        }

        if(Objects.nonNull(keyNode)) {
            keyNode.setData(last.getData());
            if(isLeft) {
                parentOfLastNode.setLeft(null);
            } else {
                parentOfLastNode.setRight(null);
            }
            return true;
        }
        return false;
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
