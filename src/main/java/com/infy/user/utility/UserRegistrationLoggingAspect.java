package com.infy.user.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserRegistrationLoggingAspect {
	private Logger logger = LogManager.getLogger(this.getClass());

	@AfterThrowing(pointcut = "execution(* com.infy.user.service.*Impl.*(..))", throwing = "exception")
	public void logServiceException(Exception exception)throws Exception {
		logger.error(exception.getMessage(), exception);
	}
}