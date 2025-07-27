package com.shadangi54.example;

import java.util.concurrent.atomic.AtomicInteger;

public class LockFreeCASExample {
//Without using CAS 
	int counter = 0;
	// Using CAS
	AtomicInteger atomicCounter = new AtomicInteger(0);

	public void increment() {
		counter++;
		atomicCounter.incrementAndGet();
	}

	public int getAtomicCount() {
		return this.atomicCounter.get();
	}

	public int getCount() {
		return this.counter;
	}

	public static void main(String[] args) {
		LockFreeCASExample obj = new LockFreeCASExample();
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 200; i++) {
				obj.increment();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 200; i++) {
				obj.increment();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Counter Value ::" + obj.getCount());
		System.out.println("Atomic Counter Value ::" + obj.getAtomicCount());
	}
}
