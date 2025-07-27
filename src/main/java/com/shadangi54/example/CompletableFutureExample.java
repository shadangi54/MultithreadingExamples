package com.shadangi54.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->{
				try {
					Thread.sleep(5000);
					System.out.println("Thread ::"+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return "Completed Task";
		}).thenApply((String val) -> {
			System.out.println("Apply ::"+Thread.currentThread().getName());
			return val + " --> theApply()";
		}).thenApplyAsync((String val) ->{
			System.out.println("Async Apply ::"+Thread.currentThread().getName());
			return val+" --> thenAsyncApply()";
		});
		
		future.thenAccept(result -> System.out.println("Result ::"+result));
		
		String val = future.get();
		System.out.println("Get val ::"+val);
	}
}
