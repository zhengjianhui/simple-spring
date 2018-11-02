package zjh.codecraft.ioc.aop.cut;

import java.lang.reflect.Method;

/**
 * Pointcut表达式 判断方法是否满足切入点
 *
 * @author zhengjianhui on 11/1/18
 */
public interface MethodMatcher {

    /**
     * Pointcut表达式 判断方法是否满足切入点
     *
     * @param method      方法
     * @param targetClass 类
     * @return 匹配结果
     */
    boolean matches(Method method, Class targetClass);

}
