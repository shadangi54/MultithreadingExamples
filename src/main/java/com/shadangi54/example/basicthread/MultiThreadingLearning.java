package com.shadangi54.example.basicthread;

public class MultiThreadingLearning implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread running ::" + Thread.currentThread().getName());
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start ::" + Thread.currentThread().getName());
		MultiThreadingLearning mtl1 = new MultiThreadingLearning();

		Thread thread1 = new Thread(mtl1);
		thread1.start();		

		System.out.println("End ::" + Thread.currentThread().getName());

	}

}
