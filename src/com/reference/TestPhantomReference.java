package com.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class TestPhantomReference {
	public static void main(String[] args) {
		Object obj1 = new Object();
		ReferenceQueue<Object> queue = new ReferenceQueue<>();
		PhantomReference<Object> pr = new PhantomReference<>(obj1, queue);
		System.out.println(obj1);
		System.out.println(pr.get());
		System.out.println(queue.poll());

		obj1 = null;
		System.gc();
		System.out.println(obj1);
		System.out.println(pr.get());
		System.out.println(queue.poll());
	}
}
