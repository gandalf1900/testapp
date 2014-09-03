package no.web.util;

/**
 * Because the interface DoubleFunction requires the implementation of only a single method it is a candidate for lambda expressions.
 */

@FunctionalInterface
public interface DoubleFunction {
    public double f(double x);

}