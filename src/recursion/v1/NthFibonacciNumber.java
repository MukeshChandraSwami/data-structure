package recursion.v1;

public class NthFibonacciNumber {

    public static void main(String[] args) {
        int n = 8;
        int fibonacciNumber = getNthFibonacci(n);
        System.out.println(n + "th fibonacci number is:- " + fibonacciNumber);
    }

    private static int getNthFibonacci(int n) {

        // Base conditions
        if(n == 0)
            return 0;

        if(n == 1)
            return 1;

        // Solving smaller problems
        int s1 = getNthFibonacci(n - 1);
        int s2 = getNthFibonacci(n - 2);

        // Calculation
        return s1 + s2;
    }
}
