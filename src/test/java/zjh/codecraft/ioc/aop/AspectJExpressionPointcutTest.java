package zjh.codecraft.ioc.aop;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

import zjh.codecraft.ioc.TestBean;
import zjh.codecraft.ioc.aop.cut.AspectJExpressionPointcut;

/**
 * @author zhengjianhui on 11/2/18
 */
public class AspectJExpressionPointcutTest {

//    private static String expression = "execution(* zjh.codecraft.ioc.*.*(..))";
    private static String expression = "execution(* zjh.codecraft.ioc..*.*(..))";

    @Test
    public void classTest() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);

        boolean flag = pointcut.getClassFilter().matches(TestBean.class);
        Assert.assertTrue(flag);

    }

    @Test
    public void methodTest() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);
        Method method = TestBean.class.getDeclaredMethod("test");
        boolean flag = pointcut.getMethodMatcher().matches(method, TestBean.class);
        Assert.assertTrue(flag);
    }
}
