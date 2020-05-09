package com.test.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
	Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		TestLock test = new TestLock();
		for (int i = 0; i < 100; i++) {
			new Thread() {
				public void run() {
					// System.out.println(Thread.currentThread().getName() + "获得锁");
					try {
						test.insert(Thread.currentThread());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				};
			}.start();

		}
	}

	protected void insert(Thread currentThread) throws InterruptedException {
		// lock.lock();
		// System.out.println(currentThread.getName() + "获得锁");
		// try {
		// for (int i = 0; i < 3; i++) {
		// System.out.println(currentThread.getName() + " " + i);
		// }
		// } catch (Exception e) {
		// System.out.println(e);
		// } finally {
		// System.out.println(currentThread.getName() + "释放锁");
		// lock.unlock();
		// }

		if (lock.tryLock(10, TimeUnit.SECONDS)) {
			try {
				System.out.println(currentThread.getName() + "获得锁");
				for (int i = 0; i < 3; i++) {
					System.out.println(currentThread.getName() + " " + i);
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				System.out.println(currentThread.getName() + "释放锁");
				lock.unlock();
			}
		} else {
			System.out.println(currentThread.getName() + "获取锁失败");
		}

	}

}
