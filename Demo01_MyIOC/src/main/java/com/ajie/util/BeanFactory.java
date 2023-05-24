package com.ajie.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ajie
 * @date 2023/5/24
 * @description:
 */
public class BeanFactory {

    private static Map<String, Object> iocMap = new HashMap<>();

    static {
        try {
            // 1. 加载配置文件
            InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.xml");
            // 2. 使用 dom4j 解析配置文件
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(resourceAsStream);
            // 3. 编写 xPath 表达式
            String xPath = "//bean";
            // 3. 获取 bean 标签
            List<Element> beanList = document.selectNodes(xPath);
            // 3. 遍历并创建实例，存放在 ioc 容器中
            for (Element element : beanList) {
                String id = element.attributeValue("id");
                String className = element.attributeValue("value");
                // 创建实例对象
                Object o = Class.forName(className).newInstance();
                iocMap.put(id, o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据 beanId 获取实例对象
     */
    public static Object getBean(String beanId) {
        return iocMap.get(beanId);
    }


}
