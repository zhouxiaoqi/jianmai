package cn.zhouqifun.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by zhouqi on 2017/4/7.
 */
@Aspect
public class AnnotationAspect {

   /* @Pointcut("execution(* cn.zhouqifun.service.*.*(..))")
    private void pointCutMethod(){}

    // 前置通知
    @Before("pointCutMethod()")
    public void Before(){
        System.out.println("我是前置通知");
    }

    @After("pointCutMethod()")
    public void After(){
        System.out.println("我是后置通知");
    }*/
}
