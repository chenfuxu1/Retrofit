package com.htd.sample.baseurl;

import okhttp3.HttpUrl;

import java.lang.reflect.Field;


/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-28 15:11
 * <p>
 * Desc: 动态切换 BASE_URL
 */
public class HttpUrlHelper {
    private static final Field sHostField;
    private final HttpUrl mHttpUrl;

    static {
        Field field = null;
        try {
            field = HttpUrl.class.getDeclaredField("host");
            field.setAccessible(true);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        sHostField = field;
    }

    public HttpUrlHelper(HttpUrl httpUrl) {
        this.mHttpUrl = httpUrl;
    }

    public HttpUrl getHttpUrl() {
        return mHttpUrl;
    }

    public void setHost(String host) {
        try {
            sHostField.set(mHttpUrl, host);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
