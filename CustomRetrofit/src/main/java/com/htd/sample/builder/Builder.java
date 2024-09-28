package com.htd.sample.builder;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-28 21:03
 * <p>
 * Desc:
 */
public abstract class Builder<T extends Builder> {
    private long delay;

    public long getDelay() {
        return delay;
    }

    public T delay(long delay) {
        this.delay = delay;
        return (T) this;
    }

    public abstract Event build();
}
