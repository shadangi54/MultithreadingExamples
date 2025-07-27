package com.shadangi54.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureExample {
	
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
				new CustomThreadFactory(), new CustomRejectionHandler());
		
		Future<?> future = executor.submit(() ->{
			try {
				Thread.sleep(7000);
				System.out.println("Task processed by ::"+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		System.out.println("Is done ::"+future.isDone());
		
		try {
			System.out.println("Get time for 2 seconds ::"+future.get(2, TimeUnit.SECONDS));
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			System.out.println("Get ::"+future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
