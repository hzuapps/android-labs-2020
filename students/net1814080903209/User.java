package edu.hzuapps.androidlabs.entity;

public class User {
    private String name;
    private String sex;
    private String age;
    private String occupation;
    private String avator;

    public User(String name, String sex, String age, String occupation, String avator) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.occupation = occupation;
        this.avator = avator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }
}
