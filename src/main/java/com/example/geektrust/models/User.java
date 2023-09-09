package com.example.geektrust.models;

public class User implements Comparable<User> {
   
    private String id;
    private String name;
    private String userName;
    private String status;
    private Course course;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {

        return this.id + " "
                + this.userName + " " +
                " " + this.course + " " + this.status ;
    }

    @Override
    public int compareTo(User o) {

        return this.id.compareTo(o.getId());
    }
}
