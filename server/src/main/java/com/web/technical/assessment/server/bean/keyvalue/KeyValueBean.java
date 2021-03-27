package com.web.technical.assessment.server.bean.keyvalue;

/**
 * Project server
 * User : suren_v
 * Date : 03/27/2021
 * Time : 11:25 PM
 */
public class KeyValueBean<T> {
    private String key;
    private T value;

    public KeyValueBean() {
    }

    public KeyValueBean(String key, T value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
