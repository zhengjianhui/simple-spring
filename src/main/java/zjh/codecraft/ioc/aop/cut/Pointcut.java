package zjh.codecraft.ioc.aop.cut;

/**
 * 对 ClassFilter 和 MethodMatcher 实现类的抽象
 *
 * @author zhengjianhui on 11/1/18
 */
public interface Pointcut {

    /**
     * 获取 class 匹配
     *
     * @return ClassFilter
     */
    ClassFilter getClassFilter();

    /**
     * 获取 method 匹配
     *
     * @return MethodMatcher
     */
    MethodMatcher getMethodMatcher();
}
