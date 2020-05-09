package com.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 隊列最大長度為Integer.MAX_VALUE,可能導致OOM
 * 
 * @author SEN.CHEN
 *
 */
public class FixedThreadPool {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 10; i++) {
			int cnt = i;
			es.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(LocalDateTime.now() + " 線程： " + Thread.currentThread() + "負責 " + cnt);
				}
			});
		}
		es.shutdown();
	}

}
