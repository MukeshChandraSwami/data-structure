package utils;

import stack.conversion.ExpressionType;
import tree.binary.Tree;
import tree.binary.common.TreeNode;
import tree.bst.BST;

import java.util.LinkedList;
import java.util.Random;

public class DSUtils {

    public static final int[] IN_ORDER = {40,39,42,55,62,70,79,84,91};
    public static final int[] PRE_ORDER = {62,40,42,39,55,91,79,70,84};
    public static final int[] POST_ORDER = {39,55,42,40,70,84,79,91,62};
    public static final int[] LEVEL_ORDER = {62,40,91,42,79,39,55,70,84};

    public static int precedence(char op) {
        int precedence = -1;
        switch(op) {
            case '+':
            case '-':
                precedence = 1;
                break;
            case '*':
            case '/':
                precedence = 2;
                break;
            case '^':
                precedence = 3;
                break;
        }
        return precedence;
    }

    public static boolean checkIfOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static ExpressionType checkExpressionType(String expression) {
        ExpressionType type = null;
        if(checkIfOperator(expression.charAt(0))) {
            type = ExpressionType.PREFIX;
        } else if(checkIfOperator(expression.charAt(expression.length() - 1))) {
            type = ExpressionType.POSTFIX;
        } else {
            type = ExpressionType.INFIX;
        }
        return type;
    }

    public static int performOperation(int first, int second, char operator) {
        int result = 0;
        switch (operator){
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            case '/':
                result = first / second;
                break;
        }
        return result;
    }


    /**
     * @return
     * In-order :   40	|	39	|	42	|	55	|	62	|	70	|	79	|	84	|	91	|
     * Pre-order : 	62	|	40	|	42	|	39	|	55	|	91	|	79	|	70	|	84	|
     * Post-order : 39	|	55	|	42	|	40	|	70	|	84	|	79	|	91	|	62	|
     * Level-order : 62 |   40  |   91  |   42  |   79  |   39  |   55  |   70  |   84  |
     *
     *                           62
     *                       /       \
     *                     /          \
     *                   40           91
     *                    \           /
     *                    42        79
     *                   /  \      /  \
     *                 39    55   70   84
     *
     */
    public static Tree getTree() {
        Tree tree = new Tree(62);
        // Setting left sub tree
        tree.getRoot().setLeft(new TreeNode(40));
        tree.getRoot().getLeft().setRight(new TreeNode(42));
        tree.getRoot().getLeft().getRight().setLeft(new TreeNode(39));
        tree.getRoot().getLeft().getRight().setRight(new TreeNode(55));

        // Setting right sub tree.
        tree.getRoot().setRight(new TreeNode(91));
        tree.getRoot().getRight().setLeft(new TreeNode(79));
        tree.getRoot().getRight().getLeft().setLeft(new TreeNode(70));
        tree.getRoot().getRight().getLeft().setRight(new TreeNode(84));

        return tree;
    }

    /**
     * @return
     * In-order :
     * Pre-order :
     * Post-order :
     * Level-order :
     *
     *                           1
     *                       /       \
     *                     /          \
     *                   4             8
     *                    \           /
     *                    16        11
     *                   /  \      /  \
     *                  6    5    12   9
     *                              \
     *                               8
     */
    public static Tree getTreeWithSmallNumbers() {
        Tree tree = new Tree(1);
        // Setting left sub tree
        tree.getRoot().setLeft(new TreeNode(4));
        tree.getRoot().getLeft().setRight(new TreeNode(16));
        tree.getRoot().getLeft().getRight().setLeft(new TreeNode(6));
        tree.getRoot().getLeft().getRight().setRight(new TreeNode(5));

        // Setting right sub tree.
        tree.getRoot().setRight(new TreeNode(8));
        tree.getRoot().getRight().setLeft(new TreeNode(11));
        tree.getRoot().getRight().getLeft().setLeft(new TreeNode(12));
        tree.getRoot().getRight().getLeft().setRight(new TreeNode(9));

        tree.getRoot().getRight().getLeft().getLeft().setRight(new TreeNode(8));

        return tree;
    }



    public static LinkedList<TreeNode> getLLTree() {

        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(new TreeNode(62));
        list.addLast(new TreeNode(40));
        list.addLast(new TreeNode(91));
        list.addLast(new TreeNode(42));
        list.addLast(new TreeNode(79));
        list.addLast(new TreeNode(39));
        list.addLast(new TreeNode(55));
        list.addLast(new TreeNode(70));
        list.addLast(new TreeNode(84));

        return list;
    }

    public static Tree getSymmetricBinaryTree() {

        Tree tree = new Tree(62);

        // Setting left sub tree
        tree.getRoot().setLeft(new TreeNode(40));
        tree.getRoot().getLeft().setLeft(new TreeNode(31));
        tree.getRoot().getLeft().getLeft().setLeft(new TreeNode(84));
        tree.getRoot().getLeft().getLeft().setRight(new TreeNode(99));
        tree.getRoot().getLeft().setRight(new TreeNode(42));
        tree.getRoot().getLeft().getRight().setLeft(new TreeNode(39));
        tree.getRoot().getLeft().getRight().setRight(new TreeNode(55));

        tree.getRoot().setRight(new TreeNode(40));
        tree.getRoot().getRight().setLeft(new TreeNode(42));
        tree.getRoot().getRight().getLeft().setLeft(new TreeNode(55));
        tree.getRoot().getRight().getLeft().setRight(new TreeNode(39));
        tree.getRoot().getRight().setRight(new TreeNode(31));
        tree.getRoot().getRight().getRight().setLeft(new TreeNode(99));
        tree.getRoot().getRight().getRight().setRight(new TreeNode(84));

        return tree;
    }

    /**
     * @return
     *
     *                           62
     *                       /       \
     *                     /          \
     *                   /             \
     *                 /                \
     *                40                 91
     *              /   \              /    \
     *            31      42          79     93
     *          /   \   /  \       /  \     /  \
     *        84   99  39    55   70   87  21  22
     *
     */

    public static Tree getPerfectBinaryTree3Levels() {
        Tree tree = new Tree(62);

        leftTree(tree);

        rightTree(tree);

        return tree;
    }

    public static Tree leftTree(Tree tree) {
        // Setting left sub tree
        tree.getRoot().setLeft(new TreeNode(40));
        tree.getRoot().getLeft().setLeft(new TreeNode(31));
        tree.getRoot().getLeft().getLeft().setLeft(new TreeNode(84));
        tree.getRoot().getLeft().getLeft().setRight(new TreeNode(99));
        tree.getRoot().getLeft().setRight(new TreeNode(42));
        tree.getRoot().getLeft().getRight().setLeft(new TreeNode(39));
        tree.getRoot().getLeft().getRight().setRight(new TreeNode(55));

        return tree;
    }

    public static Tree rightTree(Tree tree) {

        // Setting right sub tree.
        tree.getRoot().setRight(new TreeNode(91));
        tree.getRoot().getRight().setLeft(new TreeNode(79));
        tree.getRoot().getRight().getLeft().setLeft(new TreeNode(70));
        tree.getRoot().getRight().getLeft().setRight(new TreeNode(87));
        tree.getRoot().getRight().setRight(new TreeNode(93));
        tree.getRoot().getRight().getRight().setLeft(new TreeNode(21));
        tree.getRoot().getRight().getRight().setRight(new TreeNode(22));

        return tree;
    }


    public static Tree getPerfectBinaryTree2Levels() {
        Tree tree = new Tree(10);

        tree.getRoot().setLeft(new TreeNode(8));
        tree.getRoot().getLeft().setLeft(new TreeNode(3));
        tree.getRoot().getLeft().setRight(new TreeNode(5));

        tree.getRoot().setRight(new TreeNode(12));
        tree.getRoot().getRight().setLeft(new TreeNode(2));
        tree.getRoot().getRight().setRight(new TreeNode(0));

        return tree;
    }

    public static Tree getMirrorOfPerfectBinaryTree2Levels() {
        Tree tree = new Tree(10);

        tree.getRoot().setLeft(new TreeNode(2));
        tree.getRoot().getLeft().setLeft(new TreeNode(0));
        tree.getRoot().getLeft().setRight(new TreeNode(2));

        tree.getRoot().setRight(new TreeNode(8));
        tree.getRoot().getRight().setLeft(new TreeNode(5));
        tree.getRoot().getRight().setRight(new TreeNode(3));

        return tree;
    }

    public static Tree getSumBT() {
        Tree tree = new Tree(20);

        tree.getRoot().setLeft(new TreeNode(8));
        tree.getRoot().getLeft().setLeft(new TreeNode(3));
        tree.getRoot().getLeft().setRight(new TreeNode(5));

        tree.getRoot().setRight(new TreeNode(2));
        tree.getRoot().getRight().setLeft(new TreeNode(2));
        tree.getRoot().getRight().setRight(new TreeNode(0));

        return tree;
    }


    public static int[] reverse(int arr[]) {

        for(int i = 0, j = arr.length - 1; i > j; i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static TreeNode getTernaryTree() {
        // Level 0
        TreeNode root = new TreeNode(30);

        // Level 1
        root.setLeft(new TreeNode(5));
        root.setMiddle(new TreeNode(11));
        root.setRight(new TreeNode(63));

        // Level 2
        root.getLeft().setLeft(new TreeNode(1));
        root.getLeft().setMiddle(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(8));

        root.getMiddle().setLeft(new TreeNode(6));
        root.getMiddle().setMiddle(new TreeNode(7));
        root.getMiddle().setRight(new TreeNode(15));

        root.getRight().setLeft(new TreeNode(31));
        root.getRight().setMiddle(new TreeNode(55));
        root.getRight().setRight(new TreeNode(65));

        return root;
    }

    public static Tree getInvalidLogicalAND() {

        // Level 0
        Tree root = new Tree(1);

        // Level 1
        root.getRoot().setLeft(new TreeNode(1));
        root.getRoot().setRight(new TreeNode(0));

        // Level 2
        root.getRoot().getLeft().setLeft(new TreeNode(0));
        root.getRoot().getLeft().setRight(new TreeNode(1));

        root.getRoot().getRight().setLeft(new TreeNode(1));
        root.getRoot().getRight().setRight(new TreeNode(1));

        return root;
    }
    /**
     * @return
     *
     *                           4
     *                       /       \
     *                     /          \
     *                   3             5
     *                    \           /
     *                    2          6
     *                   /  \      /  \
     *                 1     1   7     7
     *
     */
    public static Tree getContinuousTree() {
        Tree tree = new Tree(4);
        // Setting left sub tree
        tree.getRoot().setLeft(new TreeNode(3));
        tree.getRoot().getLeft().setRight(new TreeNode(2));
        tree.getRoot().getLeft().getRight().setLeft(new TreeNode(1));
        tree.getRoot().getLeft().getRight().setRight(new TreeNode(1));

        // Setting right sub tree.
        tree.getRoot().setRight(new TreeNode(5));
        tree.getRoot().getRight().setLeft(new TreeNode(6));
        tree.getRoot().getRight().getLeft().setLeft(new TreeNode(7));
        tree.getRoot().getRight().getLeft().setRight(new TreeNode(7));

        return tree;
    }

    /********************* BST ***********************/

    public static final int[] IN_ORDER_BST = {5,6,7,9,10,12,15,17,18};
    public static final int[] PRE_ORDER_BST = {10,5,7,6,9,18,15,12,17};
    public static final int[] POST_ORDER_BST = {6,9,7,5,12,17,15,18,10};
    public static final int[] LEVEL_ORDER_BST = {10,5,18,7,15,6,9,12,17};

    /**
     * In-Order :   5	|	6	|	7	|	9	|	10	|	12	|	15	|	17	|	18	|
     * Pre-Order :  10	|	5	|	7	|	6	|	9	|	18	|	15	|	12	|	17	|
     * Post-Order : 6	|	9	|	7	|	5	|	12	|	17	|	15	|	18	|	10	|
     * Level-Order :10	|	5	|	18	|	7	|	15	|	6	|	9	|	12	|	17	|
     *
     *                           10
     *                       /       \
     *                     /          \
     *                    5           18
     *                    \           /
     *                    7         15
     *                   /  \      /  \
     *                  6    9   12   17
     *
     */
    public static BST getBST() {
        BST tree = new BST(10);

        // Setting left sub tree
        tree.insert(5);
        tree.insert(7);
        tree.insert(6);
        tree.insert(9);
        /*tree.insert(3);
        tree.insert(0);*/

        // Setting right sub tree.
        tree.insert(18);
        tree.insert(15);
        tree.insert(12);
        tree.insert(17);

        return tree;
    }

    public static void printRandom(int limit) {
        new Random()
                .ints(1, 100)
                .distinct()
                .limit(limit)
                .forEach(i -> System.out.print("\t" + i + "\t|"));
    }
}
