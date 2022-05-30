package recursion.v1;

public class CalculatePower {

    public static void main(String[] args) {
        int x = 2;
        int n = 4;

        int power = power(x,n);
        System.out.println(power);
    }

    private static int power(int x, int n) {

        // Base Condition
        if(n == 0)
            return 1;

        // Solve small problems
        int s = power(x, n-1);

        // Calculation
        return x * s;
    }
}
