package com.htd.sample.baseurl;

import java.lang.reflect.Field;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-28 15:33
 * <p>
 * Desc: 常量测试
 */
public class ConstTest {
    // final 修饰的相当于编译期常量，无法改写
    // private final int a = 1;
    // private int b = 1;
    private final static int c = 1;

    public static void main(String[] args) throws Exception {
        // ConstTest constTest = new ConstTest();

        // accessToFinalInt(constTest);

        accessToStaticFinalInt();
    }

    // private static void accessToFinalInt(ConstTest constTest) throws NoSuchFieldException, IllegalAccessException {
    //     System.out.println(constTest.a); // 1
    //     System.out.println(constTest.b); // 1
    //     Field aField = ConstTest.class.getDeclaredField("a");
    //     aField.setAccessible(true);
    //     aField.set(constTest, 2);
    //
    //     Field bField = ConstTest.class.getDeclaredField("b");
    //     bField.setAccessible(true);
    //     bField.set(constTest, 2);
    //     System.out.println(constTest.a); // 1
    //     System.out.println(constTest.b); // 2
    // }

    /**
     * Can not set static final int field com.htd.sample.baseurl.ConstTest.c
     */
    private static void accessToStaticFinalInt() throws NoSuchFieldException, IllegalAccessException {
        System.out.println(ConstTest.c); // 1

        Field cField = ConstTest.class.getDeclaredField("c");
        cField.setAccessible(true);
        cField.set(null, 2);

        System.out.println(ConstTest.c); // 1
    }
}
