package searching;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50,60,70,80,90,100};
        int element = 100;

        //boolean isAvailable = search(arr, element);
        boolean isAvailable = searchRecursion(arr, element, 0, arr.length - 1);
        System.out.println("Is available : " + isAvailable);
    }

    public static boolean search(int[] arr, int element) {

        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == element) {
                return true;
            } else if (element < arr[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static boolean searchRecursion(int[] arr, int element, int start, int end) {

        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == element)
                return true;
            else if (element < arr[mid])
                return searchRecursion(arr, element, start, mid - 1);
            else
                return searchRecursion(arr, element, mid + 1, end);
        }
        return false;
    }
}
