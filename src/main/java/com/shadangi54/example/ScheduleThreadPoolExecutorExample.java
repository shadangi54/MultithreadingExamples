package com.shadangi54.example;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolExecutorExample {
	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

		executor.schedule(() -> {
			System.out.println("Task executed after 2 seconds delay");
		}, 2, TimeUnit.SECONDS);
		
		Future<?> future = executor.schedule(() -> {
			return "Task executed after 2 seconds delay and returning a value";
		}, 2, TimeUnit.SECONDS);

		try {
			System.out.println(future.get()); // This will block until the task completes and returns the value
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		executor.scheduleAtFixedRate(() -> {
			System.out.println("Task executed at fixed rate of 3 seconds");
		}, 0, 3, TimeUnit.SECONDS);

		executor.scheduleWithFixedDelay(() -> {
			System.out.println("Task executed with fixed delay of 4 seconds");
		}, 0, 4, TimeUnit.SECONDS);

		// Shutdown the executor after some time to allow scheduled tasks to complete
		try {
			Thread.sleep(15000); // Wait for 15 seconds to see the scheduled tasks in action
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown(); // Shutdown the executor
			System.out.println("Executor shutdown");
		}
	}
}
