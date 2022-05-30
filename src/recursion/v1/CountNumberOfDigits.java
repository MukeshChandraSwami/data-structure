package recursion.v1;

public class CountNumberOfDigits {

    public static void main(String[] args) {

        int num = 42009;
        int count = countNumberOfDigits(num);
        System.out.println(count);
    }

    private static int countNumberOfDigits(int num) {
        // Base Case
        if(num == 0)
            return 0;

        // Solve smaller problems
        int s = countNumberOfDigits(num / 10);

        // Calculations
        return 1 + s;
    }
}
