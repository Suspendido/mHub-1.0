package dev.sumando.mhub.utility;

import dev.sumando.mhub.mHub;

public class Tasks {

    private static final mHub INSTANCE = mHub.getInstance();

    public static void runTimer(Runnable runnable, long delay, long period) {
        INSTANCE.getServer().getScheduler().runTaskTimer(INSTANCE, runnable, delay, period);
    }

    public static void runTimerAsync(Runnable runnable, long delay, long period) {
        try {
            INSTANCE.getServer().getScheduler().runTaskTimerAsynchronously(INSTANCE, runnable, delay, period);
        } catch (IllegalStateException e) {
            runTimer(runnable, delay, period); // Fallback to synchronous execution
        }
    }
}
