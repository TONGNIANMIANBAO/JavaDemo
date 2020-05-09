package com.test.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(5, () -> {
			System.out.println(Thread.currentThread().getName() + "\t cyclic barrier finish");
		});

		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				try {
					System.out.println(Thread.currentThread().getName() + "\t NB");
					cb.await();
					System.out.println(Thread.currentThread().getName() + "\t await fin");
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();

		}
	}

}
