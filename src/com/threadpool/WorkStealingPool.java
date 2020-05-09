package com.threadpool;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 隊列最大長度為Integer.MAX_VALUE,可能導致OOM
 * 
 * @author SEN.CHEN
 *
 */
public class WorkStealingPool {

	public static void main(String[] args) {
		ExecutorService es = Executors.newWorkStealingPool();//默认CPU线程数量
		for (int i = 0; i < 10; i++) {
			int cnt = i;
			// es.submit(new Runnable() {
			// @Override
			// public void run() {
			// System.out.println(LocalTime.now() + " 線程： " + Thread.currentThread() + " " +
			// cnt);
			// }
			// });
			es.submit(() -> System.out.println(LocalTime.now() + " 線程： " + Thread.currentThread() + " " + cnt));
		}

		while (true) {

		}
	}

}
