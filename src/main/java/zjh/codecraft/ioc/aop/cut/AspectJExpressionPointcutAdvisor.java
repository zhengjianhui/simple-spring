package zjh.codecraft.ioc.aop.cut;

import org.aopalliance.aop.Advice;

/**
 * 持有切面和切入点
 * 用于后续是否用代理加强的判断和加强方法的切入点判断
 *
 * @author zhengjianhui on 11/1/18
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
