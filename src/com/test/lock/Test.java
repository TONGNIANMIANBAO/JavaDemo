package com.test.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {

	static ReadWriteLock lock = new ReentrantReadWriteLock();

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					testRLck(Thread.currentThread().getName());
				}
			}).start();
		}
	}

	public static void testRLck(String name) {
		Lock readLock = lock.readLock();// 读锁，其他线程可获得读锁，但不能获得写锁
		try {
			readLock.lock();
			System.out.println(name + "获得锁");
			long start = System.currentTimeMillis();
			while (System.currentTimeMillis() - start <= 1) {
				// System.out.println(name + "...");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println(name + "释放锁");
			readLock.unlock();
		}
	}

	public static void testWLck(String name) {
		Lock writeLock = lock.writeLock();// 写锁，其他线程不能获得读锁和写锁
		try {
			writeLock.lock();
			System.out.println(name + "获得锁");
			long start = System.currentTimeMillis();
			while (System.currentTimeMillis() - start <= 1) {
				// System.out.println(name + "...");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println(name + "释放锁");
			writeLock.unlock();
		}
	}

	public static synchronized void testSyn(String name) {
		System.out.println(name + "获得锁");
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < 1) {
			// System.out.println(name + "...");
		}

		System.out.println(name + "释放锁");

	}
}
