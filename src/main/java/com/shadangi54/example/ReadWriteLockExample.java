package com.shadangi54.example;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
	
	boolean isAvailable = false;
	
	public void produce(ReadWriteLock lock) {
		try {
			lock.readLock().lock();
			System.out.println("Read lock acquired ::"+Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.readLock().unlock();
			System.out.println("Read lock released ::"+Thread.currentThread().getName());
		}
	}
	
	public void consume(ReadWriteLock lock) {
		try {
			lock.writeLock().lock();
			System.out.println("Write lock acquired ::"+Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.writeLock().unlock();
			System.out.println("Write lock released ::"+Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		ReadWriteLockExample obj = new ReadWriteLockExample();
		ReadWriteLock lock = new ReentrantReadWriteLock();
		ReadWriteLockExample obj2 = new ReadWriteLockExample();
		Thread t1 = new Thread(()->obj.produce(lock));
		Thread t2 = new Thread(()->obj.produce(lock));
		Thread t3 = new Thread(()->obj2.consume(lock));
		
		t1.start();
		t2.start();
		t3.start();
	}
}
