package com.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Singleton5 s1 = Singleton5.Singleton5;

		FileOutputStream fos = new FileOutputStream("D:\\classLog\\uiRest.log");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.flush();
		oos.close();

		FileInputStream fis = new FileInputStream("D:\\classLog\\uiRest.log");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Singleton5 s2 = (Singleton5) ois.readObject();
		ois.close();

		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

	}

}
