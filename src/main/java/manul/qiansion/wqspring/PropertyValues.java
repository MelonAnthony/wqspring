package manul.qiansion.wqspring;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Anthony
 * @Date: 2019/6/14 17:52
 * @Description:
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

    public PropertyValues(){

    }

    public void addPropertyValue(PropertyValue propertyValue){
        //TODO:这里可以对于重复propertyName进行判断，直接用list没法做到
        this.propertyValues.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValues;
    }
}
