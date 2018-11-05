package zjh.codecraft.ioc.aop;

/**
 * @author zhengjianhui on 11/3/18
 */
public abstract class AbstractAopProxy implements AopProxy {

    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
