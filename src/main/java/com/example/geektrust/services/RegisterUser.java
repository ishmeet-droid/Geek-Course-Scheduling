package com.example.geektrust.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.geektrust.models.Course;
import com.example.geektrust.models.User;

public class RegisterUser {


  
    private List<Course> courses;

    private Map<String, Integer> courseFreq;
    private Map<String, Course> courseMap;

    private Map<String, User> users;

    // private String[] commandsAndParams;

    private String mess;

    public String getMess() {
        return mess;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        for (Course i : this.courses) {

            courseMap.put(i.getId(), i);
            courseFreq.put(i.getId(), 0);
        }
    }
    

    // RegisterUser(String[] commandsAndParams, List<Course> courses) {

       
    //     this.courses = courses;
    //     this.commandsAndParams = commandsAndParams;
    //     this.courseFreq = new HashMap<>();
    //     this.courseMap = new HashMap<>();
    //     this.users = new HashMap<>();
    //     for (Course i : this.courses) {

    //         courseMap.put(i.getId(), i);
    //         courseFreq.put(i.getId(), 0);
    //     }
    //     // this.registerUsers(this.commandsAndParams);
    //     this.addUsertoMap();
    // }

    // public void setCommandsAndParams(String[] commandsAndParams) {
    //     this.commandsAndParams = commandsAndParams;
    // }

    public RegisterUser() {

        //  this.courses = courses;
        // this.commandsAndParams = commandsAndParams;
        
        this.courseFreq = new HashMap<>();
        this.courseMap = new HashMap<>();
        this.users = new HashMap<>();
        
        // this.registerUsers(this.commandsAndParams);
        // this.addUsertoMap();
    }

    public void addUsertoMap(String[] commandAndParams) {

        try{
            User user = returnsUserObject(commandAndParams);
            users.put(user.getId(), user);

            this.mess = user.getId();


        }catch(RuntimeException e){
            // System.out.println(e.getMessage());
            this.mess = e.getMessage();
        }
    }

    private User returnsUserObject(String[] commandAndParams) {

         User user = new User();

       
        if (commandAndParams.length == 3){
            if (courseFreq.containsKey(commandAndParams[2])
                && courseFreq.get(commandAndParams[2]) < courseMap.get(commandAndParams[2]).getMaxSlot()) {
           
            String name = getUserName(commandAndParams[1]);

            user.setId("REG-COURSE-"+ name + "-" + courseMap.get(commandAndParams[2]).getCourseName());

            user.setUserName(name);

            user.setCourse(courseMap.get(commandAndParams[2]));

            user.setStatus("ACCEPTED");

            courseFreq.put(commandAndParams[2], courseFreq.get(commandAndParams[2]) + 1);

            // users.put(user.getId(), user);

            }
            else{
                throw new RuntimeException("COURSE_FULL_ERROR");
            }
        }
        else{
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
        
        return user;
    }

    private String getUserName(String string) {
        int findIndex = string.indexOf("@");
        String userName = string.substring(0, findIndex);
        return userName;
    }
    
    public void printRegisteredUser(){
        for(Map.Entry<String, User> map : users.entrySet()){

            System.out.println(map.getKey() + " " + map.getValue());
        }
    }

    public void allotCourse(String[] commandAndParams) {
    }

}
