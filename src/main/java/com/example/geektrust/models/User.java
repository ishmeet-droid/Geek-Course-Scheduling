package com.example.geektrust.models;

public class User {
    // REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES 
    private String id;
    private String userName;
    private String status;
    private Course course;

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

        return "[" + this.id + " "
                + this.userName + " " +
                this.status + " " +
                this.course + " " + " ]";
    }
}
