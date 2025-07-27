package com.shadangi54.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class InterThreadCommunication {

	boolean isAvailable = false;
	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void producer() {
		lock.lock();
		try {
			while (isAvailable) {
				// Wait until the consumer consumes the data
				condition.await();
			}
			System.out.println("Producing data...");
			isAvailable = true; // Set the flag to indicate data is available
			Thread.sleep(1000); // Simulate time taken to produce data
			System.out.println("Data produced.");
			condition.signalAll(); // Notify the consumer that data is available
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void consumer() {
		lock.lock();
		try {
			while (!isAvailable) {
				// Wait until the producer produces data
				condition.await();
			}
			System.out.println("Consuming data...");
			isAvailable = false; // Reset the flag to indicate data has been consumed
			Thread.sleep(1000); // Simulate time taken to consume data
			System.out.println("Data consumed.");
			condition.signalAll(); // Notify the producer that data has been consumed
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		InterThreadCommunication obj = new InterThreadCommunication();
		
		Thread producerThread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				obj.producer();
			}
		}, "Producer");

		Thread consumerThread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				obj.consumer();
			}
		}, "Consumer");

		producerThread.start();
		consumerThread.start();
		
		try {
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
