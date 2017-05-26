package cn.jianmai.page;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhouqi on 2017/4/14.
 */
public class testPageHelper {

    public void testPageHelper() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
}
