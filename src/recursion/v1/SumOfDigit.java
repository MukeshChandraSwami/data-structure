package recursion.v1;

public class SumOfDigit {

    public static void main(String[] args) {
        int num = 12345;

        int sum = getSumOfDigits(num);
        System.out.println(sum);
    }

    private static int getSumOfDigits(int num) {
        // Base condition
        if(num == 0)
            return 0;

        // Solving smaller problems
        int n = num % 10;
        int s = getSumOfDigits(num / 10);
        return n + s;
    }
}
