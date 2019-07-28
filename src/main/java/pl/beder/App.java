package pl.beder;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        long total = 0;
        for (int i = 0; i < 1_000_000_000; i++) {
            total += i;
        }
        long stopTime = System.nanoTime();
        long seconds = Duration.ofNanos(stopTime - startTime).toMillis();
        System.out.println(seconds + "ms");

        timePrintingWrapper(() -> somePieceOfCode(0));
    }

    private static void somePieceOfCode(long total) {
        for (int i = 0; i < 1_000_000_000; i++) {
            total += i;
        }
    }

    static void timePrintingWrapper(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long stopTime = System.nanoTime();
        long seconds = Duration.ofNanos(stopTime - startTime).toMillis();
        System.out.println(seconds + "ms");
    }
}
