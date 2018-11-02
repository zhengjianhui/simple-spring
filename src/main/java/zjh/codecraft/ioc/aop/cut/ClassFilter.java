package zjh.codecraft.ioc.aop.cut;

/**
 * Pointcut表达式 判断类是否满足切入点
 *
 * @author zhengjianhui on 11/1/18
 */
public interface ClassFilter {

    /**
     * Pointcut表达式 判断类是否满足切入点
     *
     * @param targetClass 类
     * @return 匹配结果
     */
    boolean matches(Class targetClass);
}
