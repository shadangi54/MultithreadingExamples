package com.shadangi54.example;

class Worker implements Runnable{
	
	String name;
	
	public Worker(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println("Start ::"+this.name);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End ::"+this.name);
		
	}
	
}
