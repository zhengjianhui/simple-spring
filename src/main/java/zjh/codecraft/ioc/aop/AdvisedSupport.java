package zjh.codecraft.ioc.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * 持有 aop 的元数据
 * @author zhengjianhui on 10/31/18
 */
public class AdvisedSupport {

    /**
     * 被代理对象(Joinpoint)
     */
    private TargetSource targetSource;

    /**
     * 设置拦截器(Advice)
     * 实现 MethodInterceptor 接口
     */
    private MethodInterceptor methodInterceptor;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }
}
