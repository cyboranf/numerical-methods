package java;

public class Falsi {
    static double f(double x) {
        return Math.pow(x, 2) + 2 * x - 1;
//        return Math.pow(x,3) - 2*Math.pow(x,2) - 4*x - 7;
    }

    static double df(double x) { // pochodna funkcji
        return 2 * x + 2;
//        return 3*Math.pow(x,2) - 4*x - 4;
    }

    static double ddf(double x) { // druga pochodna funkcji
        return 2;
//        return 6*x - 4;
    }

    public static void main(String[] args) {

        double dok = 0.00000000001; // epsilon
        double a = -2;  // 3
        double b = 1;  //  4
        double x1 = a - (f(a) / (((f(b) - f(a)))) * (b - a));
        double x0;
        double p;  //poprzedni wynik

        if (f(a) * f(b) > 0) {
            System.out.println("Niepoprawne dane");
        } else {
            if (f(a) < 0 && ddf(b) > 0 && f(b) > 0 || f(a) > 0 && ddf(b) < 0 && f(b) < 0) {
                x0 = b;
                if (df(x0) * ddf(x0) < 0) {
                    System.out.println("Niepoprawne dane");}
                else{
                    while (Math.abs(f(x1)) > dok) {
                        p = x1;
                        x1 = p - (f(p) / (((f(x0) - f(p)))) * (x0 - p));
                    }
                    System.out.println("Pierwiastkiem rownania jest " + x1);
                }
            } else if (f(a) < 0 && ddf(a) < 0 && f(b) > 0 || f(a) > 0 && ddf(a) > 0 && f(b) < 0) {
                x0 = a;
                if(df(x0) * ddf(x0) < 0){
                    System.out.println("Niepoprawne dane");}
                else{
                    while (Math.abs(f(x1)) > dok) {
                        p = x1;
                        x1 = p - (f(p) / (((f(x0) - f(p)))) * (x0 - p));
                    }
                    System.out.println("Pierwiastkiem rownania jest " + x1);
                }
            }
        }

    }
}
