package GilLevi;

import java.util.Arrays;

public class LCS {

    public static String lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] f = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {f[i][0] = 0;}
        for (int j = 0; j < m+1; j++) {f[0][j] = 0;}
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) f[i][j] = 1 + f[i-1][j-1];
                else f[i][j] = Math.max(f[i][j-1], f[i-1][j]);
            }
        }
        // build ans
        int i = n, j = m;
        String ans = "";
        while(f[i][j] != 0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                ans = s1.charAt(i-1) + ans;
                i--; j--;
            }
            else {
                if(f[i][j-1] > f[i-1][j]) j--;
                else i--;
            }
        }
        System.out.println(Arrays.deepToString(f));
        return ans;
    }

    public static String lcs3(String x, String y, String z){
        int n = x.length(), m = y.length(), o = z.length();
        int[][][] mat3 = new int[n+1][m+1][o+1];
        for (int i = 0; i < n+1; i++) mat3[i][0][0] = 0;
        for (int j = 0; j < m+1; j++) mat3[0][j][0] = 0;
        for (int k = 0; k < o+1; k++) mat3[0][0][k] = 0;
        for(int i = 1; i < n+1; i++){
            for (int j = 1; j < m+1; j++){
                for (int k = 1; k < o+1; k++){
                    if(x.charAt(i-1) == y.charAt(j-1) && x.charAt(i-1) == z.charAt(k-1) && y.charAt(j-1) == z.charAt(k-1))
                      mat3[i][j][k] = mat3[i-1][j-1][k-1] + 1;
                    else {
                        int t = Math.max(Math.max(mat3[i - 1][j][k], mat3[i][j - 1][k]), Math.max(mat3[i - 1][j][k], mat3[i][j][k - 1]));
                        mat3[i][j][k] = Math.max(t, Math.max(mat3[i][j-1][k], mat3[i][j][k-1]));
                    }
                }
            }
        }
        int i = n;
        int j = m;
        int k = o;
        String ans = "";
        while (mat3[i][j][k] != 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1) && x.charAt(i - 1) == z.charAt(k - 1) && y.charAt(j - 1) == z.charAt(k - 1)) {
                ans = x.charAt(i - 1) + ans;
                i--;
                j--;
                k--;
            } else {
                if (mat3[i][j][k - 1] > mat3[i][j - 1][k] && mat3[i][j][k-1] > mat3[i-1][j][k]) k--;
                else if(mat3[i][j-1][k] > mat3[i-1][j][k] && mat3[i][j-1][k] > mat3[i][j][k-1]) j--;
                else i--;
            }
        }
        System.out.println(Arrays.deepToString(mat3));
        return ans;
        }


    public static void main(String[] args){
        String X = "adihoftman";
        String Y = "adihaftman";
        String Z = "adihiftman";
        //int[][] mat = LCS(X, Y);
        //System.out.println(Arrays.deepToString(LCS(X,Y)));
        //System.out.println(getSubsequence(X, Y, mat));
        System.out.println(lcs(X,Y));
        System.out.println(lcs3(X,Y,Z));
    }
}
