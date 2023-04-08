package com.xuzhuzi.exceptionhandle.asserts;

import com.xuzhuzi.exceptionhandle.exception.BaseException;

public interface Assert {
	/**
	 * 创建异常
	 * @param args
	 * @return
	 */
	BaseException newException(Object... args);

	/**
	 * 创建异常
	 * @param t
	 * @param args
	 * @return
	 */
	BaseException newException(Throwable t, Object... args);

	/**
	 * 断言对象非空。如果对象为空，则抛出异常
	 *
	 * @param obj 待判断对象
	 */
	default void assertNotNull(Object obj) {
		if (obj == null) {
			throw newException(obj);
		}
	}

	/**
	 * 断言对象非空。如果对象为空，则抛出异常
	 * 异常信息支持传递参数方式
	 *
	 * @param obj 待判断对象
	 * @param args message占位符对应的参数列表
	 */
	default void assertNotNull(Object obj, Object... args) {
		if (obj == null) {
			throw newException(args);
		}
	}
}
