package com.devdesk;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTest {
	public static void main(String[] args) {
		Lock lock1 =  new ReentrantLock();
		Lock lock2 =  new ReentrantLock();
		
		Thread t1 =  new Thread(new Runnable1(lock1,lock2));
		Thread t2 =  new Thread(new Runnable2(lock1,lock2));
		t1.setName("Thread1");
		t1.start();
		t2.setName("Thread2");
		t2.start();
		
	}
}


class Runnable1 implements Runnable{
	private Lock lock1;
	private Lock lock2;
	
	public Runnable1(Lock lock1,Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	public void run() {
		String threadName =  Thread.currentThread().getName();
		System.out.println(threadName+"- Acquiring lock1");
		lock1.lock();
		System.out.println(threadName+"- Lock1 Acquired");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println(threadName+"- is trying to Acquire lock2");
		lock2.lock();
		System.out.println(threadName+"- Lock2 Acquired");
		
		
		System.out.println(threadName+"- Release lock1");
		lock1.unlock();
		System.out.println(threadName+"- Release lock2");
		lock2.unlock();
		
	}
}

class Runnable2 implements Runnable{
	private Lock lock1;
	private Lock lock2;
	
	public Runnable2(Lock lock1,Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	public void run() {
		String threadName =  Thread.currentThread().getName();
		System.out.println(threadName+"- Acquiring lock2");
		lock2.lock();
		System.out.println(threadName+"- Lock2 Acquired");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println(threadName+"- trying to Acquire lock1");
		lock1.lock();
		System.out.println(threadName+"- Lock1 Acquired");
		
		
		System.out.println(threadName+"- Release lock2");
		lock2.unlock();
		System.out.println(threadName+"- Release lock1");
		lock1.unlock();
		
	}
}