package com.beingmate.learn.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/***
 * @author yfeng
 * @date 2018-05-21 11:22
 */
public class MathTest {
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    public static void main(String[] args) throws Throwable {
        MathTest mt = new MathTest();
        System.out.println(mt.add(3, 4));

        MethodHandles.Lookup lookup = MethodHandles.lookup();

        Class[] ptypes = {Integer.class, Integer.class};
        MethodType methodType = MethodType.methodType(Integer.class, ptypes);

        try {
            MethodHandle methodHandle = lookup.findVirtual(MathTest.class, "add", methodType);

            System.out.println(methodHandle.invoke(mt,3, 4));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
