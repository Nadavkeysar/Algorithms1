package practice;

/**
 * calculate fibonacci numbers with matrices
 * complexity = O(log n)
 */
public class FibonacciMatrix {
    private static final int[][] F = {
            {1,1},
            {1,0}
    };

    public static long fibonacciMatrix(int n) {
        int[][] ans = F;
        int[][] A = F;
        while(n != 0) {
            if(n % 2 == 1) ans = multipleMatrix2D(ans, A);
            A = multipleMatrix2D(A, A);
            n /= 2;
        }

        return ans[1][1];
    }

    /**
     * multiple by two 2D matrix
     * Complexity = O(1)
     * @param mat1
     * @param mat2
     * @return
     */
    public static int[][] multipleMatrix2D(int[][] mat1, int[][] mat2) {
        int[][] ans = new int[2][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                ans[i][j] = mat1[i][0] * mat2[0][j] + mat1[i][1] * mat2[1][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        long n = fibonacciMatrix(40);
        System.out.println(n);
    }
}
