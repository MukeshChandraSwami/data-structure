package tree.binary.common;

public class TreeNode {

    private int data;
    private int height;
    private TreeNode left;
    private TreeNode right;
    private TreeNode next;
    private TreeNode middle;

    public TreeNode(int data) {
        this.data = data;
        this.height = 1;
        this.left = this.right = this.next = this.middle = null;
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

    public TreeNode getMiddle() {
        return middle;
    }

    public void setMiddle(TreeNode middle) {
        this.middle = middle;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
