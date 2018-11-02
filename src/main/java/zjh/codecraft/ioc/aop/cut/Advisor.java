package zjh.codecraft.ioc.aop.cut;

import org.aopalliance.aop.Advice;

/**
 * pointcut
 * 用于管理切入点
 * @author zhengjianhui on 11/1/18
 */
public interface Advisor {

    Advice getAdvice();

}
