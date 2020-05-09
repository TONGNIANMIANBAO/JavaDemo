package com.testJDK18.j2014;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Workers {
	Worker[] value();
}
