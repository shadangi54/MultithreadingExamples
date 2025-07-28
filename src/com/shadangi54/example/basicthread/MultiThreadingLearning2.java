package com.shadangi54.example.basicthread;

public class MultiThreadingLearning2 extends Thread{
	
	@Override
	public void run() {
		System.out.println("Thread running ::"+Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		System.out.println("Start ::"+Thread.currentThread().getName());
		
		MultiThreadingLearning2 thread1 = new MultiThreadingLearning2();
		thread1.start();
		
		System.out.println("End ::"+Thread.currentThread().getName());
				
	}
}
