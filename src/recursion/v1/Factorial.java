package recursion.v1;

public class Factorial {

    public static void main(String[] args) {
        int num = -1;
        int factorial = getFactorial(num);
        System.out.println("Factorial of :- " + num + " is :- " + factorial);
    }

    private static int getFactorial(int num) {

        // Base conditions
        if(num == 1 || num == 0) {
            return 1;
        }
        if(num < 0) {
            throw new RuntimeException("Invalid input :- " + num);
        }

        // Solving smaller problem
        int f = getFactorial(num - 1);

        // Calculation
        return num * f;
    }
}
