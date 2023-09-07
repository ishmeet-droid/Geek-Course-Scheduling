package com.example.geektrust.models;

public class Course {

    private String id;
    private String courseName;
    private String instructorName;
    private String date;
    private int minSlot;
    private int maxSlot;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMinSlot() {
        return minSlot;
    }

    public void setMinSlot(int minSlot) {
        this.minSlot = minSlot;
    }

    public int getMaxSlot() {
        return maxSlot;
    }

    public void setMaxSlot(int maxSlot) {
        this.maxSlot = maxSlot;
    }

    @Override
    public String toString() {

        return  this.id + " "
                + this.courseName + " " +
                this.instructorName + " " +
                this.date + " "
                + this.minSlot
                + " " + this.maxSlot;
    }

}
