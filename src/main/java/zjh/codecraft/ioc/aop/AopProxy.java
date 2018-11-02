package zjh.codecraft.ioc.aop;

/**
 * aop 代理
 *
 * 织入（weave）相对简单，我们先从它开始。Spring AOP的织入点是AopProxy，它包含一个方法Object getProxy()来获取代理后的对象
 *
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
 * 完成了织入之后，我们要考虑另外一个问题：对什么类以及什么方法进行AOP？对于“在哪切”这一问题的定义
 * 我们又叫做“Pointcut”。Spring中关于Pointcut包含两个角色：ClassFilter和MethodMatcher，分别是对类和方法做匹配。
 * Pointcut有很多种定义方法，例如类名匹配、正则匹配等，但是应用比较广泛的应该是和AspectJ表达式的方式
 *
 * 连接点：程序运行中的某个阶段点，比如方法的调用、异常的抛出等。比如方法doSome();
 * Pointcut是JoinPoint的集合，它是程序中需要注入Advice 的位置的集合，指明Advice要在什么样的条件下才能被触发
 *
 * Advisor是Pointcut和Advice的配置器，它包括Pointcut和Advice，是将Advice注入程序中Pointcut位置的代码
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
