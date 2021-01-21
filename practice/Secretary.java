package practice;

import java.util.Arrays;

public class Secretary {
    public static int[] secretary(int[] queue, int[] time) {
        for(int i = 0; i < queue.length; i++) {
            for(int j = 0; j < queue.length - 1; j++) {
                if(time[queue[j] - 1] > time[queue[j + 1] - 1]) {
                    swap(queue, j, j + 1);
                }
            }
        }
        return queue;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] queue = {5,4,2,1,3};
        int[] time = {10,9,3,17,6};
        // {3,5,2,1,4}
        System.out.println(Arrays.toString(secretary(queue, time)));
    }
}
