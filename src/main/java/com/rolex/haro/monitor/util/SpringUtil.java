package com.rolex.haro.monitor.util;

import com.rolex.haro.monitor.beans.Flow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: rolex
 * Date: 2016/4/17
 * version: 1.0
 */
public class SpringUtil {

    private static ApplicationContext applicationContext;

    static {
        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    }


    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(Class<T> c) {
        return applicationContext.getBean(c);
    }

    public static <T> T getBean(String name, Class<T> c) {
        return (T) applicationContext.getBean(name);
    }
}
