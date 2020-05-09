package com.testJDK15.j2004;

/**
 * 泛型
 * @author SEN.CHEN
 *
 * @param <T>
 */
public class Box<T> {
	private T data;

	public Box(T data) {
		this.data=data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


}
