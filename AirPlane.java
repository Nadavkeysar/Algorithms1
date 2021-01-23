package practice;

public class AirPlane {

    public static double minPrice(DoubleNode[][] mat) {
        int m = mat.length, n = mat[0].length;
        mat[0][0].price = 0;

        for(int i = 1; i < n; i++) mat[0][i].price = mat[0][i-1].price + mat[0][i-1].x;
        for(int i = 1; i < m; i++) mat[i][0].price = mat[i-1][0].price + mat[i-1][0].y;

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                mat[i][j].price = Math.min(mat[i-1][j].price + mat[i-1][j].y, mat[i][j-1].price + mat[i][j-1].x);
            }
        }

        return mat[m-1][n-1].price;
    }

    public static void main(String[] args) {
        DoubleNode[][] mat = {
                {new DoubleNode(0,0),new DoubleNode(1,3),new DoubleNode(7,5),new DoubleNode(8,2)},
                {new DoubleNode(3,2),new DoubleNode(7,9),new DoubleNode(11,3),new DoubleNode(4,6)},
                {new DoubleNode(1,7),new DoubleNode(10,5),new DoubleNode(5,2),new DoubleNode(6,6)}
        };
        System.out.println(minPrice(mat));
    }
}
