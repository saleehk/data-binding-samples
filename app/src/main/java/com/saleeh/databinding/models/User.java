package com.saleeh.databinding.models;

/**
 * Created by saleeh on 30/05/15.
 */
public class User {
    private final String name;
    public final int age;
    public final String phone;

    public final String url;

    public User(String name, int age, String phone, String icon) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.url = icon;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getUrl() {
        return url;
    }
}
