package com.test.lock;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(5);

		for (int i = 0; i < 5; i++) {
			int temp = i;
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + " " + temp);
				cdl.countDown();
			}).start();
		}

		System.out.println("start");
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end");

	}

}
