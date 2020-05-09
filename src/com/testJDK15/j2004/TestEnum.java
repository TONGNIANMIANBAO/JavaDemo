package com.testJDK15.j2004;

public class TestEnum {

	/**
	 * @param args
	 * @return
	 */
	public static void main(String[] args) {
		
		System.out.println(color(ColorEnum.blue));
		for (Friut friut : Friut.values()) {
			System.out.println(friut.getName() + friut.getIndex());
		}

	}

	public static String color(ColorEnum en) {
		String res = "";
		switch (en) {
		case red:
			res = "hong";
			break;
		case write:
			res = "bai";
			break;
		case blue:
			res = "lan";
			break;
		default:
			break;
		}
		return res;
	}

	public enum Friut {
		APPLE("�L��", 1), TANGERINE("�e�a", 2);

		private String name;
		private int index;

		private Friut(String name, int index) {
			this.name = name;
			this.index = index;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
	}

	public enum ColorEnum {
		red, write, blue
	};

}
