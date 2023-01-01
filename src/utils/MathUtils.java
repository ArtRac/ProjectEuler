package utils;

public class MathUtils {

    static boolean isPerfectSquare(long n) {
        if (n <= 0) {
            return false;
        }
        double squareRoot = Math.sqrt(n);
        long tst = (long)(squareRoot + 0.5);
        return tst*tst == n;
    }
}
