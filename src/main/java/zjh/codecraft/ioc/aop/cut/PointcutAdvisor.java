package zjh.codecraft.ioc.aop.cut;

/**
 * @author zhengjianhui on 11/1/18
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
