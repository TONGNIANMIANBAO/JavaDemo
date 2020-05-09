package com.threadpool;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程执行，保证FIFO
 * 允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。 
 * @author SEN.CHEN
 *
 */
public class SingleThreadExecutor {

	public static void main(String[] args) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			int cnt = i;
			es.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(LocalTime.now() + " 線程：" + Thread.currentThread().getName() + " " + cnt);
				}
			});
		}
	}

}
