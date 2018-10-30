package zjh.codecraft.ioc;

/**
 * @author zhengjianhui on 10/30/18
 */
public class PropertyValue {

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    /**
     * 属性名
     */
    private String name;

    /**
     * 属性值
     */
    private Object value;

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
