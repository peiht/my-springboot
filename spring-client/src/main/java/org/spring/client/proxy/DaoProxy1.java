package org.spring.client.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DaoProxy1 implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("startTime:" + System.currentTimeMillis());
        method.invoke(o, objects);
        System.out.println("endTime:" + System.currentTimeMillis());
        return o;
    }
}
