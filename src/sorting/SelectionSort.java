package sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = {10,8,23,90,87,-10,4,-5,98,90,-12,36};
        System.out.print("Unsorted Array : ");
        showArray(arr);

        int sortedArr[] = sort(arr);
        System.out.print("\nSorted Array : ");
        showArray(sortedArr);
    }

    private static int[] sort(int[] arr) {

        for(int i = 0; i < arr.length; i++) {

            int pos = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[pos] > arr[j]) {
                    pos = j;
                }
            }
            if(i != pos) {
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
            }
        }
        return arr;
    }

   /* private static int[] recursiveSort(int[] arr, int sortedIndex, int unsortedIndex, int pos) {

        if(sortedIndex == arr.length)
            return arr;

        if(unsortedIndex != pos && arr[pos] > arr[unsortedIndex]) {

        }

        return null;
    } */

    private static void showArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t|\t");
        }
    }
}
