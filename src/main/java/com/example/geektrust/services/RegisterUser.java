package com.example.geektrust.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.example.geektrust.models.Course;
import com.example.geektrust.models.User;

public class RegisterUser {

    private List<Course> courses = new AddCourse().getCourses();

    private Map<String, Integer> courseFreq;
    private Map<String, Course> courseMap;

    private String[] commandsAndParams;

    RegisterUser(String[] commandsAndParams) {

        this.commandsAndParams = commandsAndParams;
        this.courseFreq = new HashMap<>();
        for (Course i : courses) {

            courseMap.put(i.getId(), i);
            courseFreq.put(i.getId(), 0);
        }
        this.registerUsers(this.commandsAndParams);
    }

    public void registerUsers(String[] commandAndParams) {

        if (courseFreq.containsKey(commandAndParams[2])
                && courseFreq.get(commandAndParams[2]) <= courseMap.get(commandAndParams[2]).getMaxSlot()) {
            User user = new User();

            user.setUserName(getUserName(commandAndParams[1]));

            user.setCourse(courseMap.get(commandAndParams[2]));

            user.setStatus("ACCEPTED");

        }

    }

    private String getUserName(String string) {
        int findIndex = string.indexOf("@");
        String userName = string.substring(0, findIndex);
        return userName;
    }

}
