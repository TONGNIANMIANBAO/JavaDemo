package com.testJDK15.j2004;

/**
 * 协变返回类型，子类重写方法返回类型与父类不同，但返回类型是父类返回类型的子类
 * @author SEN.CHEN
 *
 */
public class TestCovariantReturnType extends BaseClass{

	@Override
	public Integer getData(int a) {
		return a;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		TestCovariantReturnType co=new TestCovariantReturnType();
		System.out.print(co.getData(123));
	}

}
