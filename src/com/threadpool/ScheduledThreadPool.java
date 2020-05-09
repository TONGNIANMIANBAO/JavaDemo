package com.threadpool;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 線程數量最大為Integer.MAX_VALUE，可能導致OOM
 * 
 * @author SEN.CHEN
 *
 */
public class ScheduledThreadPool {

	public static void main(String[] args) throws Exception {
		ScheduledExecutorService es = Executors.newScheduledThreadPool(4);// corePoolSize

		// 定時，需上一任務完成，才執行下一任務
		es.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println(LocalTime.now() + " 線程： " + Thread.currentThread());
			}
		}, 1, 2, TimeUnit.SECONDS);

		// 每個任務間隔相同時間執行
		es.scheduleWithFixedDelay(() -> {
			System.out.println(LocalTime.now() + Thread.currentThread().getName());
		}, 0, 2, TimeUnit.SECONDS);
	}

}
