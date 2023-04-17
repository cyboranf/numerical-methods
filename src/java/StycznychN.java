package java;

public class StycznychN {
    static double f(double x) { // wzór funkcji
        return Math.pow(x, 2) + 2 * x - 1;
    }

    static double df(double x) { // pochodna
        return 2 * x + 2;
    }

    static double ddf(double x) { // druga pochodna
        return 2;
    }

    public static void main(String[] args) {

        double dok = 0.00000000001; // epsilon
        double a = -2;
        double b = 1;
        double x0 = 1;
        double x1;

        if (f(a) * f(b) > 0) {
            System.out.println("Niepoprawne dane");
        } else if(df(x0)*ddf(x0) < 0){
            System.out.println("Niepoprawne dane");
        } else if (f(x0)*ddf(x0)<0) {
            System.out.println("Niepoprawne dane");
        } else {
            while (Math.abs(f(x0)) > dok) {
                x1 = x0 - (f(x0) / df(x0));
                x0 = x1;
            }
        }
        System.out.println("Rozwiazaniem rownania jest " + x0);
    }
}
