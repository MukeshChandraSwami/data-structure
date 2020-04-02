package searching;

public class ExponentialSearch {

    public static void main(String[] args) {
        int arr[] = {0,  1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        int element = 1000;

        boolean isAvailable = search(arr, element);
        System.out.println("Is available : " + isAvailable);
    }

    private static boolean search(int[] arr, int element) {

        int i = 1;
        int start = 0;
        while (i < arr.length && arr[i] <= element) {
            start = i;
            i *= 2;
        }
        i = i > arr.length ? arr.length - 1 : i;

        System.out.println("Start : " + start + ", End : " + i);
        return BinarySearch.searchRecursion(arr,element,start,i);
    }
}
