package com.shadangi54.example.synchronization;

public class SharedResource {

	boolean itemAvailable = false;

	public synchronized void add() throws InterruptedException {
		System.out.println("Inside add Item ::" + Thread.currentThread().getName());
		Thread.currentThread().sleep(5000L);
		itemAvailable = true;
		notifyAll();
		System.out.println("Add item completed ::"+Thread.currentThread().getName());
	}

	public synchronized void consume() {
		System.out.println("Inside consume item ::" + Thread.currentThread().getName());

		while (!itemAvailable) {
			try {
				System.out.println("Thread waiting ::"+Thread.currentThread().getName());
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		itemAvailable = false;
		System.out.println("Completed consume item ::" + Thread.currentThread().getName());
	}
	
	
	public static void main(String[] args) {
		SharedResource obj = new SharedResource();
		
		Thread t1 = new Thread(() -> {
			try {
				obj.add();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> obj.consume());
		
		t1.start();
		t2.start();
	}
}
