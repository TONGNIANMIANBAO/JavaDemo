package com.testJDK17.j2011;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestTryWithResources {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			tryWithResources();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void tryWithResources() throws FileNotFoundException,
			IOException {
		try (FileInputStream input = new FileInputStream("C:\\temp.txt");
				BufferedInputStream buffer = new BufferedInputStream(input)) {

			byte[] bytes = new byte[1024];
			int data = buffer.read(bytes);
			while (data != -1) {
				System.out.print(new String(bytes, 0, data));
				data = buffer.read(bytes);
			}
		}
	}

}
