package practice;

import java.util.Arrays;

public class Ones {

    /**
     * return the length of the largest subsequence of ones '1'
     * using dynamic programming
     * @param arr
     * @return
     */
    public static int ones(int[] arr) {
        int n = arr.length;
        int[] help = new int[n];
        if(arr[0] == 1) help[0] = 1;

        for(int i = 1; i < n; i++) {
            if(arr[i] == 0) help[i] = 0;
            else help[i] = help[i-1] + 1;
        }

        // finding max number in help array
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(max < help[i]) max = help[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,0,1,1,1,0,0,1,1,0,0,1,1,1,1,1,0,1,0};
        System.out.println(ones(arr));
    }

}
