package com.testJDK17.j2011;

import java.io.IOException;
import java.sql.SQLException;

public class TestCatchMultipleException {

	public static void main(String[] args) throws Exception {
		try {
			testthrows();
		} catch (IOException | SQLException ex) {
			throw ex;
		}
	}

	public static void testthrows() throws Exception  {
		throw new SQLException();
	}
}
