package com.htd.sample.proxy;

import com.htd.sample.Github;
import kotlin.io.FilesKt;
// import sun.misc.ProxyGenerator;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-26 23:39
 * <p>
 * Desc: java 动态代理
 */
public class JavaDynamicProxy {
    public static void main(String[] args) {
        // writeProxyToFile();

        // testAbstractClass();
    }

    /**
     * 测试抽象类
     */
    // private static void testAbstractClass() {
        // Object proxy = Proxy.newProxyInstance(JavaDynamicProxy.class.getClassLoader(), new Class[]{SuperClass.class, Github.class},
        //         new InvocationHandler() {
        //             @Override
        //             public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //                 return null;
        //             }
        //         });
        // System.out.println(proxy);
    // }

    // private static void writeProxyToFile() {
    //     byte[] proxyClassFile = ProxyGenerator.generateProxyClass("MyProxy", new Class[]{SuperClass.class, Github.class}, Modifier.FINAL | Modifier.PUBLIC);
    //     FilesKt.writeBytes(new File("MyProxy.class"), proxyClassFile);
    // }
}
