package recursion.v3;

public class StairCaseProblem {

    public static void main(String[] args) {
        int n = 3;

        int ways = countWays(n);
        System.out.println(ways);
    }

    private static int countWays(int n) {
        if(n == 0 || n == 1)
            return 1;
        if(n == 2)
            return 2;

        return countWays(n-1) + countWays(n-2) + countWays(n-3);
    }
}
