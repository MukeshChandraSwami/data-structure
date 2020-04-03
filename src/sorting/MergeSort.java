package sorting;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {10,8,23,90,87,-10,4,-5,98,90,-12,36};
        System.out.print("Unsorted Array : ");
        showArray(arr);

        int sortedArr[] = sort(arr);
        System.out.print("\nSorted Array : ");
        showArray(sortedArr);
    }

    private static int[] sort(int[] arr) {
        return arr;
    }

    private static void showArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t|\t");
        }
    }
}
