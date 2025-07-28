package com.shadangi54.example.basicthread;

public class DaemonThread {
//Async process
	public synchronized void act() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
		}
		
		System.out.println("Act completed ::"+Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		DaemonThread ob = new DaemonThread();
		Thread t1 = new Thread(()->ob.act(), "DaemonThread");
		//It will be alive till one User thread is alive
		t1.setDaemon(true);
		t1.start();
		System.out.println("Main thread completed");
	}
}
