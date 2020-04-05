package sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int arr[] = {10,8,23,90,87,-10,4,-5,98,90,-12,36};
        System.out.print("Unsorted Array : ");
        showArray(arr);

        //int sortedArr[] = sort(arr);
        int sortedArr[] = recursiveSort(arr,1, 1);
        System.out.print("\nSorted Array : ");
        showArray(sortedArr);
    }

    private static int[] sort(int[] arr) {

        for(int i = 1; i < arr.length; i++) {
            int pos = i;
            while(pos > 0 && arr[pos-1] > arr[pos]) {
                int temp = arr[pos];
                arr[pos] = arr[pos-1];
                arr[pos-1] = temp;
                pos--;
            }
        }
        return arr;
    }

    /**
     * @param arr
     * @param index : Current index of the array. Starts from 1.
     * @param pos : This variable will back traverse the array. Starts from 1index value.
     * @return
     */
    private static int[] recursiveSort(int[] arr, int index, int pos) {

        // Exit if all the elements has been processed.
        if(index == arr.length)
            return arr;

        // Swap elements based on the below condition.
        if(pos > 0 && arr[pos-1] > arr[pos]) {
            int temp = arr[pos];
            arr[pos] = arr[pos-1];
            arr[pos-1] = temp;
            pos--;
        } else {
            // Increase array index to next index and reset pos for back traversal of the array.
            ++index;
            pos = index;
        }

        return recursiveSort(arr,index, pos);
    }

    private static void showArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t|\t");
        }
    }
}
