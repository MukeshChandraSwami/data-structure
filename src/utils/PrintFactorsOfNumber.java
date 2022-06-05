package utils;

public class PrintFactorsOfNumber {

    public static void main(String[] args) {

        int num = 100;

        for(int i = 1; i < Math.sqrt(num); i++) {

            if(num % i == 0) {
                System.out.println("(" + i + "," + num/i + ")");
            }
        }
    }
}
