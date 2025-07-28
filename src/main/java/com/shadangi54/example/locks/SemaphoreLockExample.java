package com.shadangi54.example.locks;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * This class demonstrates using Semaphores to control access to a shared
 * resource. In this example, we simulate a limited pool of database
 * connections.
 */
public class SemaphoreLockExample {

	Semaphore lock = new Semaphore(2);

	public void produce() {
		try {
			lock.acquire();
			System.out.println("Lock acquired by ::" + Thread.currentThread().getName());
			// Simulate some work with the shared resource
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.release();
			System.out.println("Lock released by ::" + Thread.currentThread().getName());
		}

	}

	public static void main(String[] args) {
		SemaphoreLockExample obj = new SemaphoreLockExample();
		Thread t1 = new Thread(() -> obj.produce());
		Thread t2 = new Thread(() -> obj.produce());
		Thread t3 = new Thread(() -> obj.produce());
		Thread t4 = new Thread(() -> obj.produce());

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
}