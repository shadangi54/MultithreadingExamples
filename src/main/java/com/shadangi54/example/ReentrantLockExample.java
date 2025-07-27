package com.shadangi54.example;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	
	public void actWithLock(ReentrantLock lock) {
		try {
			lock.lock();
			System.out.println("Lock acquired by ::"+Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
			System.out.println("Lock released by ::"+Thread.currentThread().getName());
		}
	}
	
	
	public static void main(String[] args) {
		ReentrantLockExample ob1 = new ReentrantLockExample();
		ReentrantLockExample ob2 = new ReentrantLockExample();
		
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(()->{
			ob1.actWithLock(lock);
		});
		Thread t2 = new Thread(()->{
			ob2.actWithLock(lock);
		});
		
		System.out.println("With lock");
		t1.start();
		t2.start();
	}
}
