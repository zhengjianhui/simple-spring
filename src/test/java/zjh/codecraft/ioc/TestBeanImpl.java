package zjh.codecraft.ioc;

/**
 * @author zhengjianhui on 10/29/18
 */
public class TestBeanImpl implements TestBean {

    private String test;

    private TestOutBean testOutBean;

    public void test() {
        testOutBean.test(this.test);
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void setTestOutBean(TestOutBean testOutBean) {
        this.testOutBean = testOutBean;
    }
}
