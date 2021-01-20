package LIS;

public class LIS {

    private static void LIS_subsequence(int[] arr) {
        int[][] mat = new int[arr.length][arr.length];
        mat[0][0] = arr[0];
        int lis = 1;
        for (int i = 1; i < arr.length; i++) {
            int index = FindRightIndexWithBinarySearch(mat, arr[i], 0, lis-1);
            mat[index][index] = arr[i];
            for (int j = 0; j < index; j++) {
                mat[index][j] = mat[index-1][j];
            }
            if (index == lis)
                lis++;
        }
        System.out.print("DP: LIS = " + lis + ", increasing subsequence = ");
        for (int i = 0; i < lis; i++) {
            System.out.print(mat[lis-1][i] + ", " );
        }
        System.out.println();
    }

    private static int FindRightIndexWithBinarySearch(int[][] mat, int num, int left, int right) {
        if (num < mat[left][left])
            return left;
        if (num > mat[right][right])
            return right+1;
        if (left == right)
            return left;
        int mid = (left+right)/2;
        if (mat[mid][mid]>num)
            return FindRightIndexWithBinarySearch(mat, num, left, mid);
        else
            return FindRightIndexWithBinarySearch(mat, num, mid+1, right);
    }



    public static void main(String[] args){
        int[] arr =  {5, 2, 9, 7, 8, 2, 1, 10, 6};
        LIS_subsequence(arr);
    }
}
