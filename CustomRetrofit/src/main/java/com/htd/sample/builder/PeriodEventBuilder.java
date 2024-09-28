package com.htd.sample.builder;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-28 21:06
 * <p>
 * Desc:
 */
public class PeriodEventBuilder extends Builder<PeriodEventBuilder> {
    private int duration;


    public int getDuration() {
        return duration;
    }

    public PeriodEventBuilder duration(int duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public Event build() {
        return new PeriodEvent();
    }
}
