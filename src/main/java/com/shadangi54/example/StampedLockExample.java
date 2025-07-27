package com.shadangi54.example;

import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    private String data = null;
    private final StampedLock lock = new StampedLock();
    
    public void produce(String newData) {
        long stamp = lock.writeLock();
        try {
            System.out.println("Write lock acquired :: " + Thread.currentThread().getName());
            // Update the data (producer writes data)
            this.data = newData;
            System.out.println("Produced: " + newData);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Write lock released :: " + Thread.currentThread().getName());
        }
    }
    
    public String consume() {
        // First try optimistic read - a unique feature of StampedLock
        long stamp = lock.tryOptimisticRead();
        String result = this.data;
        
        // Check if the optimistic read was valid
        if (!lock.validate(stamp)) {
            // Optimistic read failed, get a regular read lock
            stamp = lock.readLock();
            try {
                System.out.println("Read lock acquired :: " + Thread.currentThread().getName());
                // Read the data (consumer reads data)
                result = this.data;
                System.out.println("Consumed: " + result);
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
                System.out.println("Read lock released :: " + Thread.currentThread().getName());
            }
        } else {
            System.out.println("Optimistic read succeeded :: " + Thread.currentThread().getName());
            System.out.println("Consumed (optimistically): " + result);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        StampedLockExample obj = new StampedLockExample();
        
        // Producer threads
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj.produce("Data-" + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer-1");
        
        Thread t2 = new Thread(() -> {
            for (int i = 5; i < 10; i++) {
                obj.produce("Data-" + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer-2");
        
        // Consumer threads
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj.consume();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer-1");
        
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj.consume();
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer-2");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("All threads completed execution");
    }
}