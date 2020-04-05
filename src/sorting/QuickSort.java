package sorting;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {10,8,23,90,87,-10,4,-5,98,90,-12,36};
        System.out.print("Unsorted Array : ");
        showArray(arr);

        sort(arr, 0, arr.length - 1);
        System.out.print("\nSorted Array : ");
        showArray(arr);
    }

    private static void sort(int[] arr, int start, int end) {

        if(start < end) {
            // Step 1 : Find the pivot index
            int pi = partition(arr, start, end);
            // Step 2: Quick Sort left part
            sort(arr, start, pi - 1);
            // Step 3 : Quick Sort right part.
            sort(arr, pi + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {

        // Value of
        int pivotVal = arr[end];
        int i = start - 1;

        // Tracing and Swapping elements who are less then pivot value.
        for(int j = start; j < end; j++) {
            if(arr[j] < pivotVal) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swapping last element
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        // Returning pivot index.
        return i + 1;
    }

    private static void showArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t|\t");
        }
    }
}
