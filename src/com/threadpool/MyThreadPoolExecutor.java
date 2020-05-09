package com.threadpool;

import java.time.LocalTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @param corePoolSize
 *            the number of threads to keep in the pool, even if they are idle,
 *            unless {@code allowCoreThreadTimeOut} is set
 * @param maximumPoolSize
 *            the maximum number of threads to allow in the pool
 * @param keepAliveTime
 *            when the number of threads is greater than the core, this is the
 *            maximum time that excess idle threads will wait for new tasks
 *            before terminating.
 * @param unit
 *            the time unit for the {@code keepAliveTime} argument
 * @param workQueue
 *            the queue to use for holding tasks before they are executed. This
 *            queue will hold only the {@code Runnable} tasks submitted by the
 *            {@code execute} method.
 * @param threadFactory
 *            the factory to use when the executor creates a new thread
 * @param handler
 *            the handler to use when execution is blocked because the thread
 *            bounds and queue capacities are reached
 * @throws IllegalArgumentException
 *             if one of the following holds:<br>
 *             {@code corePoolSize < 0}<br>
 *             {@code keepAliveTime < 0}<br>
 *             {@code maximumPoolSize <= 0}<br>
 *             {@code maximumPoolSize < corePoolSize}
 * @throws NullPointerException
 *             if {@code workQueue} or {@code threadFactory} or {@code handler}
 *             is null
 */

public class MyThreadPoolExecutor {

	public static void main(String[] args) {
		int corePoolSize = 4;
		int maximumPoolSize = 8;
		long keepAliveTime = 300;
		TimeUnit unit = TimeUnit.SECONDS;
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
		ExecutorService es = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
				threadFactory, handler);
		for (int i = 0; i < 14; i++) {
			int cnt = i;
			
			es.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(LocalTime.now() + " 線程：" + Thread.currentThread() + " " + cnt);
				}
			});
		}
	}

}
