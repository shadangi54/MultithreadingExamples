package com.shadangi54.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExample {
// Virtual threads are a preview feature in Java 19 and later.
//Advantages of Virtual Threads:
	// 1. Lightweight: Virtual threads are much lighter than platform threads, allowing for a large number of concurrent tasks without significant overhead.
	// 2. Scalability: They enable applications to scale better by allowing more concurrent tasks to run without exhausting system resources.
	public static void main(String[] args) {
		// Create a virtual thread
		Thread virtualThread = Thread.ofVirtual().start(() -> {
			System.out.println("Hello from a virtual thread!");
			try {
				Thread.sleep(1000); // Simulate some work
			} catch (InterruptedException e) {
				System.out.println("Virtual thread interrupted");
			}
			System.out.println("Virtual thread finished work");
		});
		
		try {
			virtualThread.join(); // Wait for the virtual thread to finish
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted");
		}
		
		System.out.println("Main thread finished");
		
		
		ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
		for (int i = 0; i < 5; i++) {
			executor.submit(() -> {
				System.out.println("Hello from a virtual thread in executor!");
				try {
					Thread.sleep(500); // Simulate some work
				} catch (InterruptedException e) {
					System.out.println("Virtual thread in executor interrupted");
				}
				System.out.println("Virtual thread in executor finished work");
			});
		}
		
		executor.shutdown(); // Shutdown the executor after submitting tasks
		try {
			if (!executor.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS)) {
				System.out.println("Executor did not terminate in the specified time.");
			}
		} catch (InterruptedException e) {
			System.out.println("Executor interrupted while waiting for termination.");
		}
		System.out.println("Main thread finished after submitting tasks to executor");
	}
}
