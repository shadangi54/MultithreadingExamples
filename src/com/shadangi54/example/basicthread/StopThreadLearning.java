package com.shadangi54.example.basicthread;

public class StopThreadLearning {
	
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
		StopThreadLearning obj = new StopThreadLearning();
		Thread t1 = new Thread(() -> obj.print());
		Thread t2 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.print();
		});
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.suspend();
	}
}
