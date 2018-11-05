package zjh.codecraft.ioc;

/**
 * @author zhengjianhui on 10/29/18
 */
public class TestBeanImpl implements TestBean {

    private String test;

    private TestOutBeanImpl testOutBean;

    public void test() {
        testOutBean.test(this.test);
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void setTestOutBean(TestOutBeanImpl testOutBean) {
        this.testOutBean = testOutBean;
    }
}
