package com.test.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁，可重入
 * 
 * @author SEN.CHEN
 *
 */
public class ReentrantSpinLock {
	private AtomicReference<Thread> cas = new AtomicReference<>();
	private int cnt;

	public void lock() {
		Thread ct = Thread.currentThread();
		if (ct == cas.get()) {
			cnt++;
			return;
		}
		while (!cas.compareAndSet(null, ct)) {
		}
	}

	public void unlock() {
		Thread ct = Thread.currentThread();
		if (ct == cas.get()) {
			if (cnt > 0) {
				cnt--;
			} else {
				cas.compareAndSet(ct, null);
			}
		}
	}
}
