package edu.hzuapps.logindemo;

public class User {
    private String name;            //用户名
    private String password;        //密码
    private String phonenum;        //手机号码

    User(String name, String password,String phonenum) {
        this.name = name;
        this.password = password;
        this.phonenum = phonenum;
    }




    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phonenum='" + phonenum + '\'' +
                '}';
    }
}


