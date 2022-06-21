package recursion.v3;

// Ace the Google, Amazon, Facebook, Microsoft, Netflix coding interviews. Step by step guide for their toughest questions!
public class TowerOfHanoi {

    public static void main(String[] args) {

        int disks=3;

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


    /**
     * Formula :- (2^n) - 1
     *
     * @param disks
     * @return
     */
    private static int toh(int disks) {
        if(disks == 0)
            return 0;

        return toh(disks-1) + 1 + toh(disks - 1);
    }
}
