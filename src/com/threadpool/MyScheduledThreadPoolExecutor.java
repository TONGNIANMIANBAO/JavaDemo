package com.threadpool;

import java.time.LocalTime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyScheduledThreadPoolExecutor {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(10);//corePoolSize
		stpe.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				System.out.println(LocalTime.now() + " " + Thread.currentThread().getName());
			}
		}, 1, 4, TimeUnit.SECONDS);
	}

}
