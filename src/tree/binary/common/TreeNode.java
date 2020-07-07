package tree.binary.common;

/**
 * This is common for all types of tree. Like : BT, BST, AVL, Red-Black, Splay etc.
 */
public class TreeNode {

    private int data;
    private int height;
    private TreeNode left;
    private TreeNode right;
    private TreeNode next;
    private TreeNode middle;
    private TreeNode parent;
    private Color color;

    public TreeNode(int data) {
        this.data = data;
        this.height = 1;
        this.left = this.right = this.next = this.middle = this.parent = null;
        this.color = Color.RED;
    }

    public TreeNode(int data, Color color) {
        this.data = data;
        this.height = 1;
        this.left = this.right = this.next = this.middle = this.parent = null;
        this.color = color;
    }

    public int getData() {
        return data;
    }

    public TreeNode setData(int data) {
        this.data = data;
        return this;
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

    public TreeNode setNext(TreeNode next) {
        this.next = next;
        return this;
    }

    public TreeNode getMiddle() {
        return middle;
    }

    public TreeNode setMiddle(TreeNode middle) {
        this.middle = middle;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public TreeNode setHeight(int height) {
        this.height = height;
        return this;
    }

    public TreeNode getParent() {
        return parent;
    }

    public TreeNode setParent(TreeNode parent) {
        this.parent = parent;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public TreeNode setColor(Color color) {
        this.color = color;
        return this;
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

    public enum Color {
        RED(0,"Red"), BLACK(1,"Black");

        private int code;
        private String name;

        Color(int code, String name) {
            this.code = code;
            this.name = name;
        }
        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
