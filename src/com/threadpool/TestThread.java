package com.threadpool;

public class TestThread {
	
	public static void main(String[] args) {

		Thread thread = new Thread(new Runnable() {// 1.NEW
			@Override
			public void run() {
				synchronized (this) {// 3.BLOCKED 等待鎖
					try {
						// 4.RUNNABLE
						Thread.sleep(1000);// 5.TIMED_WAINTING
						// 6.RUNNABLE
						this.wait();// 7.WAITING 釋放鎖

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				this.notify();
				// 8.TERMINATED
			}
		});
		thread.start();// 2.RUNNABLE 等待調度
	}

}
