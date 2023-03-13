import java.util.function.Function;

public class BisectionMain {
    public static void main(String[] args) {
        Function<Double, Double> f = x -> (x+1)*Math.pow((x-1),4);
        double a = -1.5;
        double b=-0.75;
        double tolerance=0.1;
        int maxIter=100;
        System.out.println(bisection(f,a,b,tolerance,maxIter));

    }
    public static String bisection(Function<Double, Double> f, double a, double b, double tol, int maxIter) {

        /*
         * Parameters:
         *   f: A function to find the root of.
         *   a: The lower bound of the interval.
         *   b: The upper bound of the interval.
         *   tol: The tolerance for the root.
         *   maxIter: The maximum number of iterations to perform.
         *
         *
         * Returns:
         *   double: The estimated root of the function.
         */

        if (f.apply(a) * f.apply(b) > 0) {
            throw new IllegalArgumentException("f(a) and f(b) must have opposite signs for bisection method to work.");
        }

        for (int i = 0; i < maxIter; i++) {
            double c = (a + b) / 2;
            if (Math.abs(f.apply(c)) < tol) {
                return "Root: "+c;
            } else if (f.apply(a) * f.apply(c) < 0) {
                b = c;
            } else {
                a = c;
            }
        }

        throw new RuntimeException("Bisection method did not converge within the given maximum number of iterations.");
    }
}