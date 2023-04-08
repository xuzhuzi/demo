package com.xuzhuzi.exceptionhandle.handlers;

import com.xuzhuzi.exceptionhandle.exception.BaseException;
import com.xuzhuzi.exceptionhandle.exception.BusinessException;
import com.xuzhuzi.exceptionhandle.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理类
 */
@Slf4j
@ControllerAdvice
public class UnifiedExceptionHandler {
	/**
	 * 对 BusinessException 异常进行统一处理
	 *
	 * @param e 异常
	 * @return 异常结果
	 */
	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public Response handleBusinessException(BaseException e) {
		log.error("处理异常:", e);
		return new Response(e.getResponseEnum().getCode(), e.getResponseEnum().getMessage());
	}

	/**
	 * 对 BaseException 异常进行统一处理
	 *
	 * @param e 异常
	 * @return 异常结果
	 */
	@ExceptionHandler(value = BaseException.class)
	@ResponseBody
	public Response handleBaseException(BaseException e) {
		log.error("处理异常:", e);
		return new Response(e.getResponseEnum().getCode(), e.getResponseEnum().getMessage());
	}



	/**
	 * 可不用在本层对这些异常进行处理
	 * Controller上一层相关异常
	 *
	 * @param e 异常
	 * @return 异常结果
	 */
	@ExceptionHandler({
			NoHandlerFoundException.class,
			HttpRequestMethodNotSupportedException.class,
			HttpMediaTypeNotSupportedException.class,
			MissingPathVariableException.class,
			MissingServletRequestParameterException.class,
			TypeMismatchException.class,
			HttpMessageNotReadableException.class,
			HttpMessageNotWritableException.class,
			HttpMediaTypeNotAcceptableException.class,
			ServletRequestBindingException.class,
			ConversionNotSupportedException.class,
			MissingServletRequestPartException.class,
			AsyncRequestTimeoutException.class
	})
	@ResponseBody
	public Response handleServletException(Exception e) {
		log.error("处理servlet异常:", e);
		return new Response(-1, e.getMessage());
	}


	/**
	 * Controller上一层相关异常: 参数绑定异常
	 *
	 * @param e 异常
	 * @return 异常结果
	 */
	@ExceptionHandler(value = BindException.class)
	@ResponseBody
	public Response handleBindException(BindException e) {
		log.error("参数绑定校验异常:", e);

		return new Response(-1, "参数绑定校验异常");
	}

	/**
	 * Controller上一层相关异常: 参数校验异常
	 *
	 * @param e 异常
	 * @return 异常结果
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	public Response handleValidException(MethodArgumentNotValidException e) {
		log.error("参数绑定校验异常:", e);
		return new Response(-1, "参数绑定校验异常");
	}


	/**
	 * 对 未定义异常 进行统一处理
	 *
	 * @param e 异常
	 * @return 异常结果
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Response handleException(Exception e) {
		log.error("处理异常:", e);
		return new Response(-1, "处理失败，请联系开发人员");
	}
}
