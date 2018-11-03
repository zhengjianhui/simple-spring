package zjh.codecraft.ioc.aop;

/**
 * 被代理对象的封装
 * @author zhengjianhui on 10/31/18
 */
public class TargetSource {

    /**
     * 目标对象类信息
     */
    private Class targetClass;

    /**
     * 目标对象
     */
    private Object target;

    /**
     * 这边获取接口, 用于 jdk 动态代理
     * 目标对象所实现的所有接口
     */
    private Class<?>[] interfaces;

    public TargetSource(Class targetClass, Object target, Class<?>[] interfaces) {
        this.targetClass = targetClass;
        this.target = target;
        this.interfaces = interfaces;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }
}
