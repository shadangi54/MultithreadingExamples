package com.shadangi54.example.synchronization;

public class MonitorLock {
	
	public synchronized void task1() {
		try {
			System.out.println("Inside task 1");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void task2() {
		System.out.println("Inside task 2 before synchronized");
		synchronized (this) {
			System.out.println("Inside task 2 after synchronized");
		}
	}
	
	public  void task3() {
			System.out.println("Inside task 3");
	}
	
	
	public static void main(String[] args) {
		MonitorLock ml = new MonitorLock();
		Thread t1 = new Thread(()-> ml.task1());
		Thread t2 = new Thread(()-> ml.task2());
		Thread t3 = new Thread(()-> ml.task3());
			
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}
}
