package zjh.codecraft.ioc.aop;

/**
 * aop 代理
 * MethodInterceptor 和 MethodInvocation
 * 对应 Advice 和 Joinpoint
 * MethodInterceptor 对应 Advice 封装了实际代理逻辑
 * MethodInvocation 对应 joinpoint 等于实际的切入点
 *
 * JDK 代理 InvocationHandler
 * JdkDynamicAopProxy 是使用 JDK 代理所有对象的代理都会这个类的实例对象
 *
 * 本质等于生成 JDK 代理对象 JdkDynamicAopProxy
 * 代理对象执行时都会进入到 invoke 代理方法
 * JdkDynamicAopProxy 持有的 AdvisedSupport
 * AdvisedSupport 持有  MethodInterceptor 实际增加逻辑
 * MethodInterceptor invoke 执行 MethodInvocation 切入并增强
 *
 * @author zhengjianhui on 10/31/18
 */
public interface AopProxy {

    /**
     * 获取代理
     * @return proxy
     */
    Object getProxy();
}
