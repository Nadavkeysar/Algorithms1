package SquareMatrix;

public class MatrixOne {

    public static int subMatrix(int[][] mat) {
        int n = mat.length;
        int maxDim = 0;
        int[][] help = new int[n][n];
        for (int j = 0; j < n; j++) {
            help[0][j] = mat[0][j];
            help[j][0] = mat[j][0];
        }
        for (int i = 1; i < n; i++)
            for (int j = 1; j < n; j++)
                if (mat[i][j] == 1) {
                    help[i][j] = min(help[i - 1][j - 1], help[i - 1][j], help[i][j - 1]) + 1;
                    if (help[i][j] > maxDim) maxDim = help[i][j];
                }
        return maxDim;
    }

    public static int min(int a, int b, int c) {
        int min = a;
        if (min > b) min = b;
        if (min > c) min = c;
        return min;
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
        double d = (double)(end - start)/1000.0;
        System.out.println(d);

    }
}
