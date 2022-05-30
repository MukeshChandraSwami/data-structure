package recursion.v3;

public class TowerOfHanoi {

    public static void main(String[] args) {

        int disks=10;

        int steps = toh(disks);
        System.out.println(steps);

        printSteps(disks, "S", "D", "H");
    }

    private static void printSteps(int disks, String source, String destination, String helper) {
        if(disks == 0)
            return;

        printSteps(disks - 1, source, helper, destination);
        System.out.println("Disk : " + disks + "  " + source + "  ->  " + destination);
        printSteps(disks - 1, helper, destination, source);
    }

    private static int toh(int disks) {
        if(disks == 0)
            return 0;

        return toh(disks-1) + 1 + toh(disks - 1);
    }
}
