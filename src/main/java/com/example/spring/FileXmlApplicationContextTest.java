package com.example.spring;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Created: lidong on 2022/5/19 11:44 AM
 * @Description: TODO
 * @version: 1.0.0
 */
public class FileXmlApplicationContextTest {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("src/main/resources/spring-text.xml");
        TestBean testBean = (TestBean)fileSystemXmlApplicationContext.getBean("testBean");
        testBean.print();
    }
}
