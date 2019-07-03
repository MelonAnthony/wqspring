package manul.qiansion.wqspring.beans;

/**
 * @Auther: Anthony
 * @Date: 2019/6/14 17:54
 * @Description:
 */
public class PropertyValue {

    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
