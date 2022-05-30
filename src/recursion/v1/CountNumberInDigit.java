package recursion.v1;

public class CountNumberInDigit {

    public static void main(String[] args) {

        int counter = countNumber(0, 3000100);
        System.out.println(counter);
    }

    private static int countNumber(int n, int num) {
        // Base condition
        if(num == 0)
            return 0;

        // Solving small problems
        int r = num % 10;
        int s = countNumber(n, num/10);

        // calculation.
        return r == n ? s+1: s;
    }
}
