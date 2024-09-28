package com.htd.sample.builder;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-28 21:13
 * <p>
 * Desc:
 */
public class Main {
    public static void main(String[] args) {
        /**
         * 这样每次返回都是父类的 Builder，获取不到子类的方法，很不方便
         * 可以给 Builder 增加泛型
         */
        // Event fixedTimeEvent = new FixedTimeEventBuilder()
        //         .delay(100)
        //         .build();

        Event fixedTimeEvent = new FixedTimeEventBuilder()
                .delay(100)
                .second(200)
                .build();
    }
}
