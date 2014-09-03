package no.web.util;

public class DoubleFunctionSineAdapter implements DoubleFunction {

    public double f(double x) {
        return Math.sin(x);
    }
}