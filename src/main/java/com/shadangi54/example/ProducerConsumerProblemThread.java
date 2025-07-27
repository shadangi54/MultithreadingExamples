package com.shadangi54.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblemThread {
	
	Queue<String> queue = new LinkedList<>();
	int capacity = 5;
	
	
	public synchronized void produce(String value) throws InterruptedException {
		while(queue.size() == capacity) {
			System.out.println("Producer waiting as queue is full::"+Thread.currentThread().getName());
			wait();
		}
		
		queue.add(value);
		System.out.println("Produced Value"+value);
		
		notify();
	}
	
	
	public synchronized void consume() throws InterruptedException {
		while(queue.size()==0) {
			System.out.println("Consumer waiting as queue is empty::"+Thread.currentThread().getName());
			wait();
		}
		
		String value = queue.poll();
		System.out.println("Consumed ::"+value);
		
		notify();
	}
	
	public static void main(String[] args) {
		ProducerConsumerProblemThread obj = new ProducerConsumerProblemThread();
		
		Thread t1 = new Thread( () -> {
			for(int i=0; i<10; i++) {
				try {
					obj.produce(String.valueOf(i));
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "Producer");
		
		Thread t2 = new Thread(() ->{
			for(int i=0; i<10; i++) {
				try {
//					Thread.sleep(5000);
					obj.consume();
					Thread.sleep(500);
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
			}
		}, "Consumer");
		
		t1.start();
		t2.start();
	}
	

}
