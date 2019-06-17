package manul.qiansion.wqspring.xml;

import manul.qiansion.wqspring.AbstractBeanDefinitionReader;
import manul.qiansion.wqspring.BeanDefinition;
import manul.qiansion.wqspring.PropertyValue;
import manul.qiansion.wqspring.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: Anthony
 * @Date: 2019/6/17 15:18
 * @Description:
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinition(String location) throws Exception {
        InputStream is = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinition(is);
    }

    protected void doLoadBeanDefinition(InputStream is) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(is);

        //解析bean
        registerBeanDefinition(doc);
        is.close();
    }

    /**
     * 将xml解析为BeanDefinition
     * @param doc
     */
    private void registerBeanDefinition(Document doc) {
        Element root = doc.getDocumentElement();
        parseBeanDefinition(root);
    }

    /**
     * 解析每一个节点
     * @param doc
     */
    private void parseBeanDefinition(Element doc) {
        NodeList nodeList = doc.getChildNodes();
        for(int i=0;i<nodeList.getLength();i++){
//            System.out.println(nodeList.item(i));
            Node node = nodeList.item(i);
            if(node instanceof Element){
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }

    }

    /**
     * 获取节点信息并放入map中
     * @param ele
     */
    private void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("name");
        String className = ele.getAttribute("class");
        BeanDefinition bd = new BeanDefinition();
        processProperty(ele,bd);
        bd.setBeanClassName(className);
        getRegistryMap().put(name,bd);
    }

    /**
     * BeanDefition属性配置
     * @param ele
     * @param bd
     */
    private void processProperty(Element ele, BeanDefinition bd) {
        NodeList propertyNode = ele.getElementsByTagName("property");
        for(int i=0;i<propertyNode.getLength();i++){
            Node node = propertyNode.item(i);
            if(node instanceof Element){
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                PropertyValue propertyValue = new PropertyValue(name,value);
                bd.getPropertyValues().addPropertyValue(propertyValue);
            }
        }
    }

}
