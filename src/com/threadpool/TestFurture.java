package com.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TestFurture {
	public static void main(String[] args) {

		FutureTask<String> ft = new FutureTask<>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("good");
				return "SUCCESS";
			}

		});

		new Thread(ft).start();

		ExecutorService es = Executors.newCachedThreadPool();
		Future<String> future = es.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("bad");
				return "FAIL";
			}
		});

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					if ("FAIL".equals(future.get())) {
						System.out.println("well");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					if ("SUCCESS".equals(ft.get())) {
						System.out.println("fine");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();
		
		es.shutdown();

	}
}
