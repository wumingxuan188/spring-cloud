package com.casic.pojo;

import java.io.Serializable;

public class User  implements Serializable {
    private  String name;
    private  Integer id;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User() {
    }

    public User(String name, Integer id, Integer age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
}
