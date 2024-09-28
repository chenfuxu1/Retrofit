package com.htd.sample.proxy;

import com.htd.sample.Github;
import kotlin.io.FilesKt;


import net.sf.cglib.core.ClassGenerator;


import java.io.File;
import java.lang.reflect.Method;

import net.sf.cglib.core.DefaultNamingPolicy;
import net.sf.cglib.core.Predicate;
import net.sf.cglib.core.GeneratorStrategy;
import net.sf.cglib.core.DefaultGeneratorStrategy;
import net.sf.cglib.core.NamingPolicy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-27 22:57
 * <p>
 * Desc: 使用 Cglib 完成动态代理
 */
public class CglibSample {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SuperClass.class);
        enhancer.setInterfaces(new Class[]{Github.class, Runnable.class});

        /**
         * 返回代理对象是字符串
         */
        // enhancer.setCallback(new FixedValue() {
        //     @Override
        //     public Object loadObject() throws Exception {
        //         return "Hello cglib";
        //     }
        // });

        /**
         * 代理对象是 SuperClass
         * 返回相应的 hello 方法
         */
        // enhancer.setCallback(new InvocationHandler() {
        //     private SuperClass mSuperClass = new SuperClass("proxySuperClass");
        //
        //     @Override
        //     public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //         System.out.println("before");
        //         try {
        //             Method method1 = SuperClass.class.getMethod(method.getName(), method.getParameterTypes());
        //             return method1.invoke(mSuperClass, objects);
        //         } catch (Exception e) {
        //             e.printStackTrace();
        //             return null;
        //         } finally {
        //             System.out.println("after");
        //         }
        //     }
        // });

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return methodProxy.invoke(o, objects);
            }
        });

        class MyStrategyNamingPolicy implements GeneratorStrategy, NamingPolicy {
            private GeneratorStrategy mGeneratorStrategy = new DefaultGeneratorStrategy();
            private NamingPolicy mNamingPolicy = new DefaultNamingPolicy();
            private String mClassName = null;

            @Override
            public byte[] generate(ClassGenerator classGenerator) throws Exception {
                byte[] bytes = mGeneratorStrategy.generate(classGenerator);
                FilesKt.writeBytes(new File(mClassName + ".class"), bytes);
                System.out.println(mClassName);
                return bytes;
            }

            @Override
            public String getClassName(String prefix, String source, Object key, Predicate names) {
                mClassName = mNamingPolicy.getClassName(prefix, source, key, names);
                System.out.println(mClassName);
                return mClassName;
            }
        }

        MyStrategyNamingPolicy myStrategyNamingPolicy = new MyStrategyNamingPolicy();

        enhancer.setStrategy(myStrategyNamingPolicy);
        Object object = enhancer.create();
        System.out.println(object.toString());
        // System.out.println(object.equals(null));
        // System.out.println(((Github)object).contributors("", ""));

        ((SuperClass) object).hello();
    }
}