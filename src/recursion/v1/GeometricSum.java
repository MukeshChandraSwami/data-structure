package recursion.v1;

public class GeometricSum {

    public static void main(String[] args) {
        double sum = getGeometricSum(1);
        System.out.println(sum);
    }

    private static double getGeometricSum(int i) {
        // Base Case
        if(i == 0)
            return 1;

        // Solving smaller problems
        double s = getGeometricSum(i - 1);

        return s + (1 / Math.pow(2,i));
    }
}
