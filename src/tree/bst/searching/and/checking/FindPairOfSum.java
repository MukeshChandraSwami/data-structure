package tree.bst.searching.and.checking;

import tree.binary.common.TreeNode;
import utils.DSUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindPairOfSum {

    private static int counter = 1;

    public static void main(String[] args) {

        int sum = 15;
        Map<Integer, String> pairs = getPair(DSUtils.getBST().getRoot(), sum);
        pairs.forEach((key, s) -> {
            System.out.println(s);
        });
    }

    public static Map<Integer, String> getPair(TreeNode root, int sum) {
        Map<Integer, String> pair = new HashMap<>();
        Set<Integer> s = new HashSet<>();

        getPair(root, sum, pair, s);

        return pair;
    }

    private static void getPair(TreeNode root, int sum, Map<Integer, String> pair, Set<Integer> s) {
        if(root == null)
            return;

        if(s.contains(sum - root.getData())) {
            pair.put(counter++, "" + root.getData() + " + " + (sum - root.getData()) + " = " + sum);
        }

        s.add(root.getData());
        getPair(root.getLeft(), sum, pair, s);
        getPair(root.getRight(), sum, pair, s);
    }
}
