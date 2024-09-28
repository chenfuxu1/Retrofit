package com.htd.sample.generictype;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-28 20:05
 * <p>
 * Desc: 获取泛型参数信息
 */
public class GenericType {
    static class SuperType<T> {

    }

    static class SubType extends SuperType<String> {

    }

    public static void main(String[] args) throws Exception {
        Method method = GenericType.class.getDeclaredMethod("test", Map.class);
        // 获取方法的返回类型
        Type type = method.getGenericReturnType();
        recursivelyCheckType(type);

        System.out.println("=========================");
        // 获取参数的类型
        for (Type genericParameterType : method.getGenericParameterTypes()) {
            recursivelyCheckType(genericParameterType);
        }
        System.out.println("=========================");
        // 获取签名信息
        Field signatureField = Method.class.getDeclaredField("signature");
        signatureField.setAccessible(true);
        System.out.println(signatureField.get(method));

        System.out.println("=========================");
        // 获取父类的泛型实参
        Type superType = SubType.class.getGenericSuperclass();
        recursivelyCheckType(superType);
    }

    public static Map<List<String>, Set<Map<Number, String>>> test(Map<List<String>, Set<Map<Number, String>>> map) {
        return null;
    }

    public static void recursivelyCheckType(Type type) {
        // 判断是否是有泛型的参数类型
        if (type instanceof ParameterizedType) {
            System.out.println("ParameterizedType: " + type);
            for (Type actualTypeArgument : ((ParameterizedType) type).getActualTypeArguments()) {
                recursivelyCheckType(actualTypeArgument);
            }
        } else {
            System.out.println("Type: " + type);
        }
    }
}
