package Pizza2;

public class Pizza {
    public static int cutPizza(double x){
        if (x == (int) x) return (int)x+1;
        else return (int)x+2;
    }

    public static void main(String[] args){
        double x = 8;
        System.out.println(cutPizza(x));
    }
}
