package zjh.codecraft.ioc.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author zhengjianhui on 11/1/18
 */
public class TimerInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
         ReflectiveMethodInvocation r = (ReflectiveMethodInvocation) methodInvocation;

        System.out.println("代理增强开始, 类名:" +  r.getThis().getClass().getName() + "--方法:"+ methodInvocation.getMethod().getName() + "--时间为 :" + System.currentTimeMillis());

        Object obj = methodInvocation.proceed();

        System.out.println("代理增强结束, 类名:" +  r.getThis().getClass().getName() + "--方法:"+ methodInvocation.getMethod().getName() + "--时间为 :" + System.currentTimeMillis());

        return obj;
    }
}
