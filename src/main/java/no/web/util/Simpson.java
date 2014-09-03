package no.web.util;

public class Simpson {

    public static double integrate(DoubleFunction df, double a, double b, int n) {
        if (n < 0 || n > 100_000) {
            String message = n + "out of range";
            throw new IllegalArgumentException(message);
        } else if (b < a) {
            String message = "a must be less than b; a =" + a + ", b = " + b;
            throw new IllegalArgumentException(message);
        }

        if (a == b)
            return 0;

        double x, deltaX, sum2 = 0.0, sum4;

        if (n % 2 != 0)   // make sure that n is even
            ++n;

        deltaX = (b - a) / n;
        x = a + deltaX;
        sum4 = df.f(x);

        for (int i = 1; i <= (n - 2) / 2; ++i) {
            x = x + deltaX;
            sum2 = sum2 + df.f(x);
            x = x + deltaX;
            sum4 = sum4 + df.f(x);
        }

        return (deltaX / 3.0) * (df.f(a) + df.f(b) + 4.0 * sum4 + 2.0 * sum2);
    }
}
