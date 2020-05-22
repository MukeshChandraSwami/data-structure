package tree.binary.consutruct;

import tree.binary.common.TreeNode;
import tree.binary.traversal.TraverseWithoutRecursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Construct tree of indexes.
 * https://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
 */
public class ConstructBTFromValAndIndexOfArray {

    public static void main(String[] args) {

        int arr[] = {1, 5, 5, 2, 2, -1, 3};
        TreeNode tree = createTree(arr);
        TraverseWithoutRecursion.inOrderTraversal(tree);
    }

    public static TreeNode createTree(int[] arr) {

        Queue<Integer> index = findIndex(arr, -1);

        TreeNode root = new TreeNode(index.remove());

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            index = findIndex(arr, node.getData());

            boolean flag = true;
            while(!index.isEmpty()) {
                TreeNode treeNode = new TreeNode(index.remove());
                queue.add(treeNode);
                
                if(flag)
                    node.setLeft(treeNode);
                else
                    node.setRight(treeNode);
                flag = false;
            }
        }

        return root;
    }

    private static Queue<Integer> findIndex(int arr[], int val) {

        Queue<Integer> l = new LinkedList<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == val) {
                l.add(i);
            }
        }

        return l;
    }
}
