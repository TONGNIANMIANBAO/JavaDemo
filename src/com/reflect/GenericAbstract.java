package com.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericAbstract<DOMAIN, ID> implements GenericInterface<DOMAIN, ID> {

	public Type fetchType() {
		System.out.println(this.getClass());
		System.out.println(this.getClass().getGenericSuperclass());
		return ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
