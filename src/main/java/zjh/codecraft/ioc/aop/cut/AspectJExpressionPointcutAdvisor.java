package zjh.codecraft.ioc.aop.cut;

import org.aopalliance.aop.Advice;

/**
 * @author zhengjianhui on 11/1/18
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    @Override
    public Pointcut getPointcut() {
        return null;
    }

    @Override
    public Advice getAdvice() {
        return null;
    }
}
