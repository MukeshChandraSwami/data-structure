package recursion.v1;

public class PrintNaturalNumbers {

    public static void main(String[] args) {

        int n = 5;
        printNumbersAscOrder(n);
        System.out.println();
        printNumbersDescOrder(n);
    }

    private static void printNumbersDescOrder(int n) {

        // Base case
        if(n == 0)
            return;

        // Calculation / operation
        System.out.println(n);

        // Solving smaller problems
        printNumbersDescOrder(n - 1);
    }

    private static void printNumbersAscOrder(int n) {

        // Base Case
        if(n == 0)
            return;

        // Solving small problems
        printNumbersAscOrder(n-1);

        // Calculation / operation
        System.out.println(n);
    }
}
