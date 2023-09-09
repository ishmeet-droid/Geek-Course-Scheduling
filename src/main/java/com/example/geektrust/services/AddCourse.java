package com.example.geektrust.services;

import java.util.ArrayList;
import java.util.List;

import com.example.geektrust.models.Course;

public class AddCourse {

    // private String[] commandsAndParams;

    private List<Course> courses;

    

    private String mess;

    // public AddCourse(String[] commandsAndParams) {
    //     this.commandsAndParams = commandsAndParams;
    //     this.courses = new ArrayList<>();
    //     this.addCourseToList();
    // }

    public AddCourse() {
        // this.commandsAndParams = commandsAndParams;
        this.courses = new ArrayList<>();
        // this.addCourseToList();
    }

    public String getMess() {
        return mess;
    }

    public List<Course> getCourses() {
        return courses;
    }

    

    public void addCourseToList(String[] commandsAndParams) {

        try{
            Course obj = returnsCourseObject(commandsAndParams);
            courses.add(obj);
            this.mess = obj.getId();


        }catch(RuntimeException e){
            // System.out.println(e.getMessage());
            this.mess = e.getMessage();
        }
    }

    private Course returnsCourseObject(String[] commandsAndParams) {

        Course course = new Course();

        // for(String j : commandsAndParams){
        // System.out.println(j);
        // }
        if (commandsAndParams.length == 6) {

            course.setId("OFFERING-" + commandsAndParams[1] + "-" + commandsAndParams[2]);
            course.setCourseName(commandsAndParams[1]);
            course.setInstructorName(commandsAndParams[2]);
            course.setDate(commandsAndParams[3]);
            course.setMinSlot(Integer.parseInt(commandsAndParams[4]));
            course.setMaxSlot(Integer.parseInt(commandsAndParams[5]));

        } else {
            throw new RuntimeException("INPUT_DATA_ERROR");
            // throw new Exception("(because of missing instructor and course-offering-date)
            // ", INPUT_DATA_ERROR);
        }

        return course;

    }

    public void printListOfCourses() {
        for (Course i : courses) {
            System.out.println(i.toString());
        }
    }

    

}
