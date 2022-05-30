package recursion.v1;

public class MultiplicationByAddingNumbers {

    public static void main(String[] args) {
        int result = multiply(3,4);
        System.out.println(result);
    }

    private static int multiply(int m, int n) {
        // Base condition
        if(n == 0)
            return 0;

        // Solving smaller problems
        int s = multiply(m,n - 1);

        // Calculation
        return s + m;
    }
}
