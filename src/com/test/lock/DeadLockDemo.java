package com.test.lock;

class MyThread implements Runnable {

	private String lockA;
	private String lockB;

	public MyThread(String lockA, String lockB) {
		super();
		this.lockA = lockA;
		this.lockB = lockB;
	}

	@Override
	public void run() {
		synchronized (lockA) {
			System.out.println(Thread.currentThread().getName() + "\t 持有" + lockA + ",嘗試獲取" + lockB);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lockB) {
				System.out.println(Thread.currentThread().getName() + "\t 持有" + lockB + ",嘗試獲取" + lockA);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

public class DeadLockDemo {

	public static void main(String[] args) {
		String lockA = "A";
		String lockB = "B";
		new Thread(new MyThread(lockA, lockB), "AAA").start();
		new Thread(new MyThread(lockB, lockA), "BBB").start();
	}

}
