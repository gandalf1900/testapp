package no.web.data;

import no.web.util.DoubleFunction;
import no.web.util.DoubleFunctionSineAdapter;
import no.web.util.Simpson;
import org.apache.commons.math.util.MathUtils;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.concurrent.Executor;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

public class TestLamda {

    DoubleFunction sineAdapter;

    @Before
    public void setup() {
        sineAdapter = new DoubleFunction() {
            @Override
            public double f(double x) {
                return Math.sin(x);
            }
        };
    }

    @Test
    public void testNoLambda() {
        DoubleFunctionSineAdapter sine = new DoubleFunctionSineAdapter();
        double result = Simpson.integrate(sine, 0, Math.PI, 30);

        assertThat(result).isPositive();
        System.out.println(result);
    }

    @Test
    public void testNoLambdaWithAnonInnerClass() {
        double result = Simpson.integrate(sineAdapter, 0, Math.PI, 30);

        assertThat(result).isPositive();
        System.out.println(result);
    }

    @Test
     public void testLambda() {
        DoubleFunction sine = (double x) -> Math.sin(x);
        double result = Simpson.integrate(sine, 0, Math.PI, 30);

        assertThat(result).isPositive();
        System.out.println(result);
    }

    @Test
    public void testLambdaEvenShorter() {
        double result = Simpson.integrate((double x) -> Math.sin(x), 0, Math.PI, 30);

        assertThat(result).isPositive();
        System.out.println(result);
    }

    @Test
    public void testLambdaEvenEvenShorter() {
        double result = Simpson.integrate(Math::sin, 0, Math.PI, 30);

        assertThat(result).isPositive();
        System.out.println(result);
    }


    @Test
    public void testYetAnotherOldWayOfDoingStuff() {
        JButton button = new JButton();
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        doSomethingWith(e);
                    }

                });
        button.doClick();
    }

    @Test
    public void testYetAnotherOldWayOfDoingStuffNowWithLambda() {
        JButton button = new JButton();
        button.addActionListener(e -> doSomethingWith(e));
        button.doClick();
    }

    @Test
    public void testLamda2() {
        String[] testStrings = { "biglargetext", "thou", "shall", "not", "pass" };
        System.out.println(testStrings[0]+", "+testStrings[1]+", "+testStrings[2]+", "+testStrings[3]+", "+testStrings[4]);
        //Sort based on length of string..Calling sort with my own comparator
        Arrays.sort(testStrings, (s1, s2) -> s1.length() - s2.length());
        System.out.println(testStrings[0]+", "+testStrings[1]+", "+testStrings[2]+", "+testStrings[3]+", "+testStrings[4]);
    }


    @Test
    public void testTaskListWithoutLambda() {
        Executor taskList = new Executor() {
            @Override
            public void execute(Runnable command) {
                System.out.println("execute me..");
            }
        }  ;

        taskList.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("im running..");
            }
        });

        taskList.execute(() -> processSomeImage("my image"));

    }

    private void processSomeImage(String s) {
    }


    private void doSomethingWith(ActionEvent e) {
        System.out.println("I just did something..");

    }
}
