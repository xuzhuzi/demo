package com.xuzhuzi.exceptionhandle.asserts;

import com.xuzhuzi.exceptionhandle.enums.IResponseEnum;
import com.xuzhuzi.exceptionhandle.exception.BaseException;
import com.xuzhuzi.exceptionhandle.exception.BusinessException;

import java.text.MessageFormat;

public interface BusinessExceptionAssert extends IResponseEnum, Assert {

	@Override
	default BaseException newException(Object... args) {
		String msg = MessageFormat.format(this.getMessage(), args);

		return new BusinessException(this, args, msg);
	}

	@Override
	default BaseException newException(Throwable t, Object... args) {
		String msg = MessageFormat.format(this.getMessage(), args);

		return new BusinessException(this, args, msg, t);
	}

}
