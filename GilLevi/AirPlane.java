package GilLevi;

import java.util.ArrayList;

public class AirPlane {
    private AirPlaneNodeExtra[][] mat;
    private int rows;
    private int cols;
    private int MaxPrice;
    private int CountMaxPricePaths;
    private ArrayList<String> AllPaths;

    public AirPlane(AirPlaneNodeExtra[][] matrix) {
        mat = matrix;
        MaxPrice = 0;
        CountMaxPricePaths = 0;
        AllPaths = new ArrayList<String>();
        rows = mat.length;
        cols = mat[0].length;
        Go();
        buildPaths(mat, rows - 1, cols - 1, "", AllPaths);
        ReverseGo();
    }

    private void Go() {
        mat[0][0].value = 0;
        mat[0][0].count = 1;
        for (int j = 1; j < mat[0].length; j++) {
            mat[0][j].value = mat[0][j - 1].value + mat[0][j - 1].right;
            mat[0][j].count = mat[0][j - 1].count;
        }
        for (int i = 1; i < mat.length; i++) {
            mat[i][0].value = mat[i - 1][0].value + mat[i - 1][0].up;
            mat[i][0].count = mat[i - 1][0].count;
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[i][j - 1].value + mat[i][j - 1].right < mat[i - 1][j].value +
                        mat[i - 1][j].up) {
                    mat[i][j].value = mat[i][j - 1].value + mat[i][j - 1].right;
                    mat[i][j].count = mat[i][j - 1].count;
                } else if (mat[i][j - 1].value + mat[i][j - 1].right > mat[i - 1][j].value
                        + mat[i - 1][j].up) {
                    mat[i][j].value = mat[i - 1][j].value + mat[i - 1][j].up;
                    mat[i][j].count = mat[i - 1][j].count;
                } else {
                    mat[i][j].value = mat[i - 1][j].value + mat[i - 1][j].up;
                    mat[i][j].count = mat[i - 1][j].count + mat[i][j].count;
                }
            }
        }
        MaxPrice = mat[mat.length - 1][mat[0].length - 1].value;
        CountMaxPricePaths = mat[mat.length - 1][mat[0].length - 1].count;
    }

    public int GetMaxPrice() {
        return MaxPrice;
    }

    public int GetCountMaxPricePaths() {
        return CountMaxPricePaths;
    }

    private void buildPaths(AirPlaneNodeExtra[][] mat, int i, int j, String path,
                            ArrayList<String> paths) {
        if (i == 0 && j == 0)
            paths.add(path);
        else if (i == 0 && j > 0) {
            buildPaths(mat, i, j - 1, "r" + path, paths);
        } else if (i > 0 && j == 0) {
            i--;
            buildPaths(mat, i - 1, j, "u" + path, paths);
        } else if (mat[i][j - 1].value + mat[i][j - 1].right < mat[i - 1][j].value
                + mat[i - 1][j].up) {
            buildPaths(mat, i, j - 1, "r" + path, paths);
        } else if (mat[i][j - 1].value + mat[i][j - 1].right > mat[i - 1]
                [j].value + mat[i - 1][j].up) {
            buildPaths(mat, i - 1, j, "u" + path, paths);
        } else // they are equals
        {
            buildPaths(mat, i - 1, j, "u" + path, paths);
            buildPaths(mat, i, j - 1, "r" + path, paths);
        }
    }

    public String GetPaths() {
        return AllPaths.toString();
    }

    private void ReverseGo() {
        int r = rows - 1;
        int c = cols - 1;
        mat[r][c].reverseValue = 0;
        for (int j = c - 1; j >= 0; j--) {
            mat[r][j].reverseValue = mat[r][j + 1].reverseValue + mat[r][j].right;
        }
        for (int i = r - 1; i >= 0; i--) {
            mat[i][c].reverseValue = mat[i + 1][c].reverseValue + mat[i][c].up;
        }
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                mat[i][j].reverseValue = Math.min(mat[i][j + 1].reverseValue + mat[i][j].right, mat[i + 1][j].reverseValue + mat[i][j].up);
            }
        }
    }

    public boolean IsPointInMinimalPath(int i, int j) {
        if (mat[i][j].value + mat[i][j].reverseValue == mat[0][0].reverseValue)
            return true;
        return false;
    }

    public static void main(String[] args) {
        AirPlaneNodeExtra[][] mat = InitMat();
        AirPlane airplane = new AirPlane(mat);
        System.out.println("Min value from (0,0) to (3,3) is: " + airplane.GetMaxPrice());
        System.out.println("Count paths = " + airplane.GetCountMaxPricePaths());
        System.out.println("All paths = " + airplane.GetPaths());
        System.out.println("Is Point (0,3) in minimal path ? " +
                airplane.IsPointInMinimalPath(0, 3));
        System.out.println("Is Point (2,2) in minimal path ? " +
                airplane.IsPointInMinimalPath(2, 2));
    }

    private static AirPlaneNodeExtra[][] InitMat() {
        AirPlaneNodeExtra[][] mat = new AirPlaneNodeExtra[4][4];
//--1----2----3--
//| | | |
//5 4 3 4
//| | | |
//--5----1----2--
//| | | |
//4 3 2 1
//| | | |
//--3----5----5--
//| | | |
//2 4 1 4
//| | | |
//--1----2----3--
        mat[0][0] = new AirPlaneNodeExtra(2, 1);
        mat[0][1] = new AirPlaneNodeExtra(4, 2);
        mat[0][2] = new AirPlaneNodeExtra(1, 3);
        mat[0][3] = new AirPlaneNodeExtra(4, 0);
        mat[1][0] = new AirPlaneNodeExtra(4, 3);
        mat[1][1] = new AirPlaneNodeExtra(3, 5);
        mat[1][2] = new AirPlaneNodeExtra(2, 5);
        mat[1][3] = new AirPlaneNodeExtra(1, 0);
        mat[2][0] = new AirPlaneNodeExtra(5, 5);
        mat[2][1] = new AirPlaneNodeExtra(4, 1);
        mat[2][2] = new AirPlaneNodeExtra(3, 2);
        mat[2][3] = new AirPlaneNodeExtra(4, 0);
        mat[3][0] = new AirPlaneNodeExtra(0, 1);
        mat[3][1] = new AirPlaneNodeExtra(0, 2);
        mat[3][2] = new AirPlaneNodeExtra(0, 3);
        mat[3][3] = new AirPlaneNodeExtra(0, 0);
        return mat;
    }
}

class AirPlaneNodeExtra {
    int up;
    int right;
    int value;
    int reverseValue;
    int count;

    AirPlaneNodeExtra(int u, int r) {
        up = u;
        right = r;
    }
}