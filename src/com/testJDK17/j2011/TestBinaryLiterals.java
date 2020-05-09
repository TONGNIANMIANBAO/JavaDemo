package com.testJDK17.j2011;

public class TestBinaryLiterals {
	
	public static void main(String[] args) {
		// An 8-bit 'byte' value:
		byte aByte =(byte) 0b1010_0001;
		System.out.println(""+aByte);

		// A 16-bit 'short' value:
		short aShort = (short) 0b1010000101000101;

		// Some 32-bit 'int' values:
		int anInt1 = 0b1010_0001_0100_0101_1010_0001_0100_0101;
		int anInt2 = 0b101;
		int anInt3 = 0B101; // The B can be upper or lower case.
		System.out.println(""+anInt3);

		// A 64-bit 'long' value. Note the "L" suffix:
		long aLong = 0b1010000101000101101000010100010110100001010001011010000101000101L;
		System.out.println(""+anInt1);
	}
}
