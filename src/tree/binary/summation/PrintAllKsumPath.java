package tree.binary.summation;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
 */
public class PrintAllKsumPath {

    private static List<Integer> l = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode root = DSUtils.getTreeWithSmallNumbers().getRoot();
        int k = 20;
        getKSumPath(root, k);
    }

    private static void getKSumPath(TreeNode root, int k) {

        if(root == null)
            return;

        l.add(root.getData());

        getKSumPath(root.getLeft(), k);
        getKSumPath(root.getRight(), k);

        int temp = 0;
        for(int i = l.size() - 1; i >= 0; i--) {

            temp += l.get(i);

            if(temp == k) {

                for(int j = i; j < l.size(); j++) {
                    System.out.print(l.get(j) + " ");
                }
                System.out.println();
            }
        }
        l.remove(l.size() - 1);
    }
}
