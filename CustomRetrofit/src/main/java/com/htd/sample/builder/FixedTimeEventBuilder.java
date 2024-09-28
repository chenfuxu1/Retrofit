package com.htd.sample.builder;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-28 21:06
 * <p>
 * Desc:
 */
public class FixedTimeEventBuilder extends Builder<FixedTimeEventBuilder> {
    private int second;
    private int minute;

    public int getSecond() {
        return second;
    }

    public FixedTimeEventBuilder second(int second) {
        this.second = second;
        return this;
    }

    public int getMinute() {
        return minute;
    }

    public FixedTimeEventBuilder minute(int minute) {
        this.minute = minute;
        return this;
    }

    @Override
    public Event build() {
        return new FixedTimeEvent();
    }
}
