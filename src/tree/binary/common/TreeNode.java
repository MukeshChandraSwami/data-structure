package tree.binary.common;

public class TreeNode {

    private int data;
    private TreeNode left;
    private TreeNode right;
    private TreeNode next;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }

    public TreeNode getNext() {
        return next;
    }

    public void setNext(TreeNode next) {
        this.next = next;
    }

    @Override
    public int hashCode() {
        return this.getData();
    }

    @Override
    public boolean equals(Object obj) {
        TreeNode obj1 = (TreeNode) obj;
        return this.data == obj1.getData();
    }
}