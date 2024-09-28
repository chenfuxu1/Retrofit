package com.htd.sample.proxy;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-27 22:34
 * <p>
 * Desc:
 */
public class SuperClass {
    private String mValue = "Hello SuperClass";

    public SuperClass() {
    }

    public SuperClass(String value) {
        mValue = value;
    }

    public void hello() {
        System.out.println(mValue);
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }
}
