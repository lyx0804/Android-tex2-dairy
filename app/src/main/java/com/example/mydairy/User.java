package com.example.mydairy;

public class User {
    private Integer id;
    private Integer userID;
    private String name;            //用户名
    private String password;        //密码
    private String title;           //日记标题
    private String content;         //日记内容
    private String time;            //时间

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User(){}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title  = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

