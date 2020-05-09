package com.trick;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "aaaabbb1111";

		Pattern p = Pattern.compile("(\\w)(\\1)(\\1)");
		Matcher m = p.matcher(s);
		while (m.find()) {
			System.out.println(m.group() + "]");
		}

		Pattern p1 = Pattern.compile("(\\w)(?=\\1)(\\1)");// ��=������Ԥ�����в�ռ���ַ�
		Matcher m1 = p1.matcher(s);
		while (m1.find()) {
			System.out.println(m1.group() + "[");
		}

		System.out.println("測試".getBytes().length);
		System.out.println("測試".getBytes("ISO8859-1").length);
		System.out.println("測試".getBytes("GBK").length);
		System.out.println("測試".getBytes("UTF-8").length);
		System.out.println("測試".getBytes("UTF-16").length);

		System.out.println(System.getProperty("file.encoding"));

	}

}
