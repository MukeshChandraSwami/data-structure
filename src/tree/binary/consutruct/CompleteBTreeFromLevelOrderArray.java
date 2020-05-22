package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.LevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBTreeFromLevelOrderArray {

    private static final int []LEVEL_ORDER = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

    public static void main(String[] args) {

        TreeNode root = constructCompleteBTree(LEVEL_ORDER);
        LevelOrderTraversal.levelOrderTraversal(root);

        System.out.println();

        root = constructCompleteBTreeViaRecursion(LEVEL_ORDER,0);
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    public static TreeNode constructCompleteBTree(int []levelOrder) {

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(levelOrder[0]);
        queue.add(root);

        for(int i = 1; i < levelOrder.length; i++) {

            TreeNode node = queue.remove();

            TreeNode left = new TreeNode(levelOrder[i]);
            queue.add(left);
            node.setLeft(left);

            if(i+1 < levelOrder.length) {
                i = i + 1;
                TreeNode right = new TreeNode(i);
                queue.add(right);
                node.setRight(right);
            }
        }

        return root;
    }

    public static TreeNode constructCompleteBTreeViaRecursion(int []arr, int i) {

        TreeNode root = null;
        if(i < arr.length) {
            root = new TreeNode(arr[i]);

            root.setLeft(constructCompleteBTreeViaRecursion(arr,(i*2)+1));

            root.setRight(constructCompleteBTreeViaRecursion(arr,(i*2)+2));
        }

        return root;
    }
}
