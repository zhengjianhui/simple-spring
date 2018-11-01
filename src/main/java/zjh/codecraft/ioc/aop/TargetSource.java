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

    public TargetSource(Class targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }

}
