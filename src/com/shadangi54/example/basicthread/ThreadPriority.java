package com.shadangi54.example.basicthread;

public class ThreadPriority {
	
	public synchronized void act() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
		}
		
		System.out.println("Act completed ::"+Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		ThreadPriority ob = new ThreadPriority();
		Thread t1 = new Thread(()->ob.act(), "PriorityThread");
		Thread t2 = new Thread(()->ob.act(), "PriorityThread2");
		//1 low 10 high
		//It doesnot gurantee priority
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		System.out.println("Main thread completed");
	}
}
