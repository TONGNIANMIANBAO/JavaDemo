package com.testJDK15.j2004;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GenericTestUnit {
	Box<Integer> i = new Box<Integer>(12);
	Box<Number> n = new Box<Number>(123);
	Box<String> s = new Box<String>("koei");

	@Test
	void testGetData() {
		Assertions.assertEquals("oei", TestGeneric.getData(s));
	}

}
