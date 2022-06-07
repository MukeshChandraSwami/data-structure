package hashing.hard;

import java.util.HashSet;
import java.util.Set;

public class TriplesInSortedArrayThatFormAP {

    private static final int[] ARR = {2, 6, 9, 12, 17, 22, 31, 32, 35, 42};

    public static void main(String[] args) {

        printAPs(ARR);
    }

    private static void printAPs(int[] arr) {

        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                int diff = arr[j] - arr[i];
                if(s.contains(arr[i] - diff)) {
                    System.out.println("AP : (" + (arr[i]-diff) + "," + arr[i] + "," +arr[j] + ")");
                }
            }
            s.add(arr[i]);
        }
    }
}
