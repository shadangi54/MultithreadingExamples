package com.shadangi54.example.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),
				new CustomThreadFactory(), new CustomRejectionHandler());
		//Try with 4(Happy Path), 5(Max size usage), 7(Rejection Case)
		List<Future<?>> futureObjs = new ArrayList<>();
		for(int i=0; i<7; i++) {
			executor.submit(()->{
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Task processed by "+Thread.currentThread().getName());
			});
		}
		
		executor.shutdown();
	}
}

class CustomThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread th = new Thread(r);
		th.setPriority(Thread.NORM_PRIORITY);
		th.setDaemon(false);
		return th;
	}

}

class CustomRejectionHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("Task rejected ::" + r.toString());
	}

}
