package sorting;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {10,8,23,90,-5,87,-10,4,-5,98,90,-12,36};
        System.out.print("Unsorted Array : ");
        showArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.print("\n\nSorted Array : ");
        showArray(arr);
    }

    private static void mergeSort(int[] arr, int lb, int ub) {

        // Check if array has more then 1 element. If this condition is true means there are at least 2 elements in array.
        if(lb < ub) {
            // Divide array in small pieces.

            // Getting mid element
            int mid = (lb + ub) / 2;
            // Dividing left sub array
            mergeSort(arr, lb, mid);
            // Dividing right sub array
            mergeSort(arr, mid + 1, ub);

            // Finally merging them.
            merge(arr, lb, mid, ub);
        }
    }

    private static void merge(int[] arr, int lb, int mid, int ub) {
        int sortedArr[] = new int[ub - lb + 1];
        int i = lb;
        int j = mid + 1;
        int index = 0;

        while(i <= mid && j <= ub) {

            if(arr[i] <= arr[j]) {
                sortedArr[index] = arr[i];
                i++;
            } else {
                sortedArr[index] = arr[j];
                j++;
            }
            index++;
        }

        if(i > mid) {
            while(j <= ub) {
                sortedArr[index] = arr[j];
                j++;
                index++;
            }
        } else if(j > ub) {
            while(i <= mid) {
                sortedArr[index] = arr[i];
                i++;
                index++;
            }
        }

        for(int a = 0; a < sortedArr.length; a++) {
            arr[lb] = sortedArr[a];
            lb++;
        }
    }

    private static void showArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t|\t");
        }
    }
}
