package sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {10,8,23,90,-5,87,-10,4,-5,98,90,-12,36};
        System.out.print("Unsorted Array : ");
        showArray(arr);

        //int sortedArr[] = sort(arr);
        int sortedArr[] = recursiveSort(arr,0,1,0);
        System.out.print("\nSorted Array : ");
        showArray(sortedArr);
    }

    private static int[] sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    private static int[] recursiveSort(int[] arr, int l, int r, int counter) {

        if(counter == arr.length)
            return arr;

        if(r == arr.length) {
            r = r -1;
            counter = counter + 1;
        }

        if(arr[l] > arr[r]) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        if (l == r) {
            l = 0;
            r = 1;
        } else {
            ++l;
            ++r;
        }

        return recursiveSort(arr, l, r, counter);
    }

    private static void showArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t|\t");
        }
    }
}
