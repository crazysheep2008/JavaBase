package com.beingmate.learn.cglib.client;

import com.beingmate.learn.cglib.service.UserService;
import com.beingmate.learn.cglib.service.impl.UserServiceImpl;
import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/***
 * @auth yfeng
 * @create 2017-04-22 20:41
 */
public class Main {
    public static void main(String[] args) {
        filterTest();
    }

    public static void filterTest() {
        Callback[] callbacks = {NoOp.INSTANCE, new LogCallBack()};
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(new MyCallbackFilter());
        UserService us = (UserService) enhancer.create();
        us.getDefaultAvatar("frank");
        us.hasMobile("frank");
        us.lastLogin("frank");
    }

    public static void defaultTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new LogCallBack());
        UserService us = (UserService) enhancer.create();
        String avatarUrl = us.getDefaultAvatar("1111");
        System.out.println("get result : " + avatarUrl);
    }

    private static class MyCallbackFilter implements CallbackFilter {

        @Override
        public int accept(Method method) {
            String methdName = method.getName();
            if (methdName.equals("getDefaultAvatar")) {
                return 1;
            }
            return 0;
        }
    }

    private static class LogCallBack implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            long start = System.currentTimeMillis();
            Object res = methodProxy.invokeSuper(o, objects);
            System.out.println(String.format("%s spend time %s ms", method.getName(), (System.currentTimeMillis() - start)));
            return res;
        }
    }
}
