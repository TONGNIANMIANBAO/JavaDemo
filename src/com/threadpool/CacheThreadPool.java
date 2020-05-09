package com.threadpool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 線程數量最大為Integer.MAX_VALUE,可能導致OOM
 * 
 * @author SEN.CHEN
 *
 */
public class CacheThreadPool {

	public static void main(String[] args) throws Exception {

		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			int cnt = i;
			es.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(
							new Date(System.currentTimeMillis()) + " 線程： " + Thread.currentThread() + "負責" + cnt);
				}
			});
			Thread.sleep(1);
		}
		es.shutdown();
	}
}
