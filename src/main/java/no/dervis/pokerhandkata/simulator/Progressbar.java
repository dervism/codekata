package no.dervis.pokerhandkata.simulator;

import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.System.lineSeparator;
import static java.lang.System.nanoTime;

public class Progressbar implements Runnable {
    private Thread worker;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private final AtomicBoolean stopped = new AtomicBoolean(true);
    private long timer;
    private double timeUsed;

    public void start() {
        worker = new Thread(this);
        worker.start();
        timer = nanoTime();
    }

    public void stop() {
        running.set(false);
        timeUsed = ((nanoTime() - timer) / 1_000_000_000d);
        System.out.printf("> %.2f sec" + lineSeparator(), timeUsed);
    }

    public double getTimeUsed() {
        return timeUsed;
    }

    public void interrupt() {
        running.set(false);
        worker.interrupt();
    }

    @Override
    public void run() {
        int tmp = 0, interval = 300;

        running.set(true);
        stopped.set(false);

        while (running.get()) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (running.get()) {
                if (++tmp % 40 == 0) {
                    System.out.print("|\n");
                } else System.out.print("|");
            }
        }

        stopped.set(true);
    }
}
