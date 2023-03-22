package function;

import static java.lang.Math.*;
public class Taylor {
    public double getAcos(double x, double accuracy) {
        if (x < -1 || x > 1) {
            throw new IllegalArgumentException();
        }
        boolean nearZero = false;
        if (x >= -0.7 && x <= 0.7) {
            nearZero = true;
        }
        double fraction = accuracy + 1;
        double acos = PI / 2;
        double up, down, end;
        int n = 0;
        while (abs(fraction) >= accuracy) {
            up = factor(2 * n);
            down = pow(4, n) * pow(factor(n), 2) * (2 * n + 1);
            if (nearZero) {
                end = pow(x, 2 * n + 1);
            } else {
                end = pow(sqrt(1 - x * x), 2 * n + 1);
            }
            fraction = up / down * end;
            acos -= fraction;
            n++;
        }
        if (!nearZero) {
            acos = x < 0 ? PI / 2 + acos : PI / 2 - acos;
        }
        return acos;
    }

    private double factor(double n) {
        if (n == 0) {
            return 1;
        }
        return n * factor(n - 1);
    }
}
