package com.example.grpwork;

public class UserHelperClass {

    String name, username,email, course,password;

    public UserHelperClass() {

    }

    public UserHelperClass(String name, String username, String email, String course, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.course = course;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
