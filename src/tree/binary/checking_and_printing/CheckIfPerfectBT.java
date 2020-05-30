package tree.binary.checking_and_printing;

import tree.binary.common.TreeNode;
import utils.DSUtils;

public class CheckIfPerfectBT {

    public static void main(String[] args) {

        boolean status = checkForPerfectBT(DSUtils.getPerfectBinaryTree2Levels().getRoot());
        System.out.print("Perfect Binary Tree : " + status);

    }

    public static boolean checkForPerfectBT(TreeNode root) {
        return check(root,0,new LeafLevel());
    }

    private static boolean check(TreeNode root, int level, LeafLevel leafLevel) {

        if(root == null)
            return true;

        if((root.getLeft() == null && root.getRight() != null) || (root.getLeft() != null && root.getRight() == null))
            return false;

        if(root.getLeft() == null && root.getRight() == null) {

            if(leafLevel.getLevel() == 0) {
                leafLevel.setLevel(level);
                return true;
            }

            return leafLevel.getLevel() == level;
        }

        return check(root.getLeft(),level + 1, leafLevel)
                && check(root.getRight(), level + 1, leafLevel);
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
