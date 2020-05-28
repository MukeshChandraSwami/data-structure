package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class CheckIfLeavesAtSameLevel {

    public static void main(String[] args) {

        TreeNode root = DSUtils.getTree().getRoot();
        boolean sameLevel = checkForSameLevels(root,0,new LeafLevel());
        System.out.print("Leaves are same level : " + sameLevel);
    }

    public static boolean checkForSameLevels(TreeNode root, int level, LeafLevel leafLevel) {

        if(root == null)
            return true;

        // Identify leaf node.
        if(root.getLeft() == null && root.getRight() == null) {

            // This will be true in case of first leaf node identification.
            if(leafLevel.getLevel() == 0) {
                leafLevel.setLevel(level);
                return true;
            } else {
                return leafLevel.getLevel() == level;
            }
        }

        return checkForSameLevels(root.getLeft(), level + 1, leafLevel)
                && checkForSameLevels(root.getRight(), level + 1, leafLevel);
    }

    private static class LeafLevel {
        private int level;

        public LeafLevel() {
            this.level = 0;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
}
