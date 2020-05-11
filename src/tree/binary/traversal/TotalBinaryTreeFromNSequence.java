package tree.binary.traversal;

public class TotalBinaryTreeFromNSequence {

    public static void main(String[] args) {

        int n = 6;
        int total = getTotalBinaryTrees(n);
        System.out.println("Total binary tree for " + n + " : " + total);
    }

    public static int getTotalBinaryTrees(int n) {
        int bt[] = new int[n+1];
        bt[0] = bt[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                bt[i] = bt[i] + bt[j] * bt[i - j - 1];
            }
        }

        return bt[n];
    }
}
