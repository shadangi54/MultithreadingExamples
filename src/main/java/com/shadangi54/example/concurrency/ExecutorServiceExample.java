package com.shadangi54.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
	
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=1; i<=6; i++) {
			Runnable worker = new Worker("Thread"+i);
			executor.submit(worker);
		}
		
		executor.shutdown();
		
		while(!executor.isTerminated()) {
//			System.out.println("Waiting for Threads to complete");
		}
		
		System.out.println("All threads completed");
	}
}
