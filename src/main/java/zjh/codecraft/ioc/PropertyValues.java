package zjh.codecraft.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * 对属性值做一些分装, 后续可以增加对属性的操作
 *
 * @author zhengjianhui on 10/30/18
 */
public class PropertyValues {

    private List<PropertyValue> propertyValues = new ArrayList();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValues.add(pv);
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValues;
    }

}
