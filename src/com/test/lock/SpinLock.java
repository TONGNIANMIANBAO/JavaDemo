package com.test.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁，非重可入
 * 
 * @author SEN.CHEN
 *
 */
public class SpinLock {

	private AtomicReference<Thread> cas = new AtomicReference<Thread>();

	public void lock() {
		Thread ct = Thread.currentThread();
		while (!cas.compareAndSet(null, ct)) {
			System.out.println(ct.getName() + " wait");
		}
	}

	public void unlock() {
		Thread ct = Thread.currentThread();
		cas.compareAndSet(ct, null);
	}

	public static void main(String[] args) {
		SpinLock sl = new SpinLock();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				sl.lock();
				System.out.println(Thread.currentThread().getName() + " lock");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sl.unlock();
				System.out.println(Thread.currentThread().getName() + " unlock");
			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				sl.lock();
				System.out.println(Thread.currentThread().getName() + " lock");
				sl.unlock();
				System.out.println(Thread.currentThread().getName() + " unlock");
			}
		}, "t2");
		t1.start();
		t2.start();
	}
}
