package java;

public class Siecznych {
    static double f(double x){ // wzór funkcji
        return Math.pow(x, 2) + 2*x - 1;
    }

    static double df(double x) { // pochodna funkcji
        return 2 * x + 2;
    }

    static double ddf(double x) { //druga pochodna funkcji
        return 2;
    }

    public static void main(String[] args) {

        double dok = 0.00000000001; //epsilon
        double a = -2;  // a, b - skrajne przypadki zbioru
        double b = 1;
        double x0 = b - f(b)*((b-a)/(f(b)-f(a)));

        if(f(a)*f(b)>0){
            System.out.println("Niepoprawne dane");
        }else if(df(x0)*ddf(x0) < 0){
            System.out.println("Niepoprawne dane");
        }
        else {
            while (Math.abs(f(x0)) > dok) {
                a = b;
                b = x0;
                x0 = b - f(b)*((b-a)/(f(b)-f(a)));
            }
            System.out.println("Pierwiastkiem rownania jest " + x0);
        }
    }
}
