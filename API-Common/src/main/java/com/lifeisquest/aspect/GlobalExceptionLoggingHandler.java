package com.lifeisquest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@Aspect
@Component
public class GlobalExceptionLoggingHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionLoggingHandler.class);

  // com.lifeisquest..controller 이하 모든 패키지 내에 속한 메소드 실행 시.
  @AfterThrowing(pointcut = "execution(* com.lifeisquest..controller..*(..))", throwing = "ex")
  public void controllerAfterThrowing(JoinPoint joinPoint, Throwable ex) {

    Signature signature = joinPoint.getSignature();
    String controllerName = signature.getDeclaringTypeName();
    String methodName = signature.getName();
    String argumentStr = Arrays.toString(joinPoint.getArgs());

    logger.error("\nError in " + controllerName + "." + methodName + " " + argumentStr, ex);
  }
}
