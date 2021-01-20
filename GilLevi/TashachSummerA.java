package GilLevi;

import java.util.Arrays;

public class TashachSummerA {
    //Q1 a
    public static int subMatrix(int[][] mat) {
        int max = 0;
        int[][] h = new int[mat.length][mat.length];
        for (int j = 0; j < mat.length; j++) h[0][j] = mat[0][j];
        for (int i = 0; i < mat.length; i++) h[i][0] = mat[i][0];
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat.length; j++) {
                if (mat[i][j] == 1) {
                    int min = Math.min(h[i - 1][j - 1], h[i - 1][j]);
                    h[i][j] = Math.min(min, h[i][j - 1]) + 1;
                    if (h[i][j] > max) max = h[i][j];
                }
            }
        }
        return max;
    }

    //b
    public static int two(int[][] h) {
        int count = 0;
        for (int i = 0; i < h.length - 1; i++) {
            for (int j = 0; j < h[0].length - 1; j++) {
                if (h[i][j] == 1 && h[i][j + 1] == 1 && h[i + 1][j] == 1 && h[i + 1][j + 1] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    //Q2
    static int computeLIS(int circBuff[], int start, int end, int n)
    {
        int LIS[] = new int[n+end-start];

        /* Initialize LIS values for all indexes */
        for (int i = start; i < end; i++)
            LIS[i] = 1;

        /* Compute optimized LIS values in bottom up manner */
        for (int i = start + 1; i < end; i++)

            // Set j on the basis of current window
            // i.e. first element of the current window
            for (int j = start; j < i; j++ )
                if (circBuff[i] > circBuff[j] && LIS[i] < LIS[j] + 1)
                    LIS[i] = LIS[j] + 1;

        /* Pick maximum of all LIS values */
        int res = Integer.MIN_VALUE;
        for (int i = start; i < end; i++)
            res = Math.max(res, LIS[i]);
        return res;
    }

    // Function to find Longest Increasing subsequence in
    // Circular manner
    static int LICS(int arr[], int n)
    {
        // Make a copy of given array by appending same
        // array elements  to itself
        int circBuff[] = new int[2 * n];
        for (int i = 0; i<n; i++)
            circBuff[i] = arr[i];
        for (int i = n; i < 2*n; i++)
            circBuff[i] = arr[i-n];

        // Perform LIS for each window of size n
        int res = Integer.MIN_VALUE;
        for (int i=0; i<n; i++)
            res = Math.max(computeLIS(circBuff, i, i + n, n), res);
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 1, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0}};

        long start = System.currentTimeMillis();
        System.out.println(subMatrix(mat));
        long end = System.currentTimeMillis();
        double d = (double) (end - start) / 1000.0;
        System.out.println(d);

        int[][] mat1 = {{0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1}};
        System.out.println(two(mat1));

        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(LICS(arr, arr.length));
    }
}
