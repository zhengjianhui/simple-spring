package zjh.codecraft.ioc.aop;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * 对 aop invoke 的参数封装
 * MethodInvocation 相当于切入点 Joinpoint
 * @author zhengjianhui on 10/31/18
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    /**
     * 被代理的对象
     */
    private Object target;

    /**
     * 被代理的方法
     */
    private Method method;

    /**
     * 被代理方法的参数
     */
    private Object[] args;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return args;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target, args);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
