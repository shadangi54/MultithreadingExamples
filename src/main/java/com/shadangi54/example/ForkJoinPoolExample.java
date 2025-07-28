package com.shadangi54.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample {
	
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		Future<Integer> future = forkJoinPool.submit(new ComputeSumTask(1, 100));
		try {
			System.out.println("Sum from 1 to 100 is: " + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class ComputeSumTask extends RecursiveTask<Integer> {
	int start;
	int end;
	
	ComputeSumTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		if(end-start <=4) {
			int total = 0;
			for(int i=start; i<=end; i++) {
				total += i;
			}
			return total; // Base case: compute the sum directly
		}else {
			int mid = (start + end) / 2;
			ComputeSumTask leftTask = new ComputeSumTask(start, mid);
			ComputeSumTask rightTask = new ComputeSumTask(mid + 1, end);
			
			leftTask.fork(); // Fork the left task
			rightTask.fork(); // Fork the right task
			
			//Combine results
			int leftResult = leftTask.join(); // Join the left task
			int rightResult = rightTask.join(); // Join the right task
			
			return leftResult + rightResult; // Combine results
		}
	}
}
