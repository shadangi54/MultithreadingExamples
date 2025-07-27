package com.shadangi54.example;

public class JoinThread {
	public synchronized void print() {
		System.out.println("Lock acquired ::"+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Lock released ::"+Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		System.out.println("Main thread started");
		JoinThread obj = new JoinThread();
		Thread t1 = new Thread(() -> obj.print());
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main thread finished");
	}
}
