package com.shadangi54.example.concurrency;

public class ThreadLocalExample {
	
	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		threadLocal.set("Hello from ThreadLocal");
		System.out.println("Main thread value: " + threadLocal.get());
		Thread thread = new Thread(() -> {
			System.out.println("ThreadLocal value in new thread: " + threadLocal.get());
			threadLocal.set("Hello from new thread");
			System.out.println("New thread set value: " + threadLocal.get());
		});
		
		thread.start();
		
		try {
			Thread.sleep(2000); // Wait for the thread to finish
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
