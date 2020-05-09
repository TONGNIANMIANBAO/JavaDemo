package com.collections;

import java.io.File;

public class TestFile {

	public static void traverseFolder(String path) {
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isDirectory()) {
					System.out.println("folder: " + f.getAbsolutePath());
					traverseFolder(f.getAbsolutePath());
				} else {
					System.out.println("file: " + f.getName());
				}
			}
		}
	}

	public static void main(String[] args) {
		String path = "D:\\log";
		traverseFolder(path);
	}
}
