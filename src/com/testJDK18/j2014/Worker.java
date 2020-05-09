package com.testJDK18.j2014;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 重複註解，允許同一位置多次使用同一註解
 * 
 * @author SEN.CHEN
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Workers.class)
public @interface Worker {
	String role();
}
