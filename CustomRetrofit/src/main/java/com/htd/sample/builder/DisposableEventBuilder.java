package com.htd.sample.builder;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-28 21:06
 * <p>
 * Desc:
 */
public class DisposableEventBuilder extends Builder<DisposableEventBuilder> {

    @Override
    public Event build() {
        return new DisposableEvent();
    }
}
