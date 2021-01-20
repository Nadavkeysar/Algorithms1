package maraton2;

import java.util.Arrays;

public class NumberGame {

    public static int numberGame(int[] arr) {
        int n = arr.length;
        int[][] m = new int[n][n];
        for(int i = 0; i < m.length; i++) {
            m[i][i] = arr[i];
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                m[i][j] = Math.max(arr[i] - m[i+1][j], arr[j] - m[i][j-1]);
            }
        }

        printMatrix(m);
        return m[0][n-1];
    }

    public static void printMatrix(int[][] m) {
        for(int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,1,3,6};
        System.out.println(numberGame(arr));
    }
}
