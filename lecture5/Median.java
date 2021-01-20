package lecture5;

import java.util.Arrays;

public class Median {
    public static void main(String[] args) {

        int[] arr = {5,6,9,4,2,4,5,8,7,4,5,3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static int medianA(int[] arr) {
        mergeSort(arr);
        if(arr.length % 2 == 0) {
            return arr[arr.length / 2];
        } else {
            return arr[(arr.length / 2) + 1];
        }
    }

    /**
     * public merge sort
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    /**
     * private merge sort
     * @param arr
     */
    private static void mergeSort(int[] arr, int low, int high) {
        if(low < high - 1) {
            int middle = (low + high) / 2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle, high);
            int n = high - low;
            int[] temp = new int[n];
            int i = low, j = middle, k = 0;

            while(i < middle && j < high) {
                if(arr[j] < arr[i]) temp[k++] = arr[j++];
                else temp[k++] = arr[i++];
            }
            while(i < middle) temp[k++] = arr[i++];
            while(j < high) temp[k++] = arr[j++];

            for(int p = 0; p < n; p++) arr[low + p] = temp[p];
        }
    }
}
