package cn.jianmai.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhouqi on 2017/4/7.
 */
@Aspect
public class AOPTest {

    @Pointcut("execution(* cn.zhouqifun.aop.*(..))")
    public void declareJoinPointExpression(){

    }

    @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.print("我是前置同志");
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();

        // 获取参数
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("The method" +methodName+ "begins with" + args);
    }
}
