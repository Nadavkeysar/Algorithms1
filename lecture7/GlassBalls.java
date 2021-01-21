package lecture7;

public class GlassBalls {

    /**
     * case when b = 2
     * define f function as:
     * f(n,2) = MIN((MAX(i, f(n-i,2) + 1), i=1,...,n))
     * @param n number of flores
     * @return f(n)
     */
    public static int GB2(int n) {
        if(n == 1) return 1;
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for(int i = 3; i <= n; i++) {
            int min = n;
            for(int j = 1; j < i; j++) {
                int x = Math.max(j, f[i-j] + 1);
                if(x < min) min = x;
            }
            f[i] = min;
        }
        return f[n];
    }

    /**
     * case when b = 3
     * @param n number of flores
     * @return
     */
    public static int GB3(int n) {
        int[] f2 = new int[n+1];
        int[] f3 = new int[n+1];
        if(n == 1) return 1;
        if(n == 2 || n == 3) return 2;
        for(int i = 2; i <= n; i++) {
            f2[i] = GB2(i);
        }
        f3[0] = 0;
        f3[1] = 1;
        f3[2] = 2;
        f3[3] = 2;
        for(int i = 4; i <= n; i++) {
            int min = n + 1;
            for(int j = 1; j < i; j++) {
                int x = Math.max(f2[j-1] +  1, f3[i-j] + 1);
                if(x < min) min = x;
            }
            f3[i] = min;
        }
        return f3[n];
    }

    /**
     * case when b = k
     * @param n number of flores
     * @param k number of glass balls
     * @return
     */
    public static int GBK(int n, int k) {
        int[][] checks = new int[k+1][n+1];

        // one ball
        for(int i = 0; i <= n; i++) {
            checks[0][i] = 0;
            checks[1][i] = i;
        }

        // i number of the ball
        for(int i = 2; i <= k; i++) {
            checks[i][0] = 0;
            checks[i][1] = 1;
            if(n >= 2) checks[i][2] = 2;

            // j - number of the ball
            for(int j = 2; j <= n; j++) {
                int min = n + 1;

                // p - number of the floor
                for(int p = 1; p < j; p++) {
                    min = Math.min(Math.max(checks[i-1][p-1], checks[i][j-p]), min) + 1;
                }
                checks[i][j] = min;

            }
        }
        return checks[k][n];
    }

    public static void main(String[] args) {
        System.out.println(GB2(5));
        System.out.println(GB3(5));
        System.out.println(GBK(5, 2));
        System.out.println(GBK(5, 3));
    }
}
