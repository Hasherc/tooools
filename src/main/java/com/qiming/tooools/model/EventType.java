package com.qiming.tooools.model;

/**
 * @tooools
 * @Description:
 * @Author: qming_c
 * @Date: 2018-02-03-22:12
 */
public enum EventType {
    /**
     * 发送邮件事件
     */
    MAIL(1);

    private int value;

    EventType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "EventType{" +
                "value=" + value +
                '}';
    }
}
