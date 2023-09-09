package com.example.geektrust.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.example.geektrust.models.Course;
import com.example.geektrust.models.User;

public class UserService {

    private List<Course> courses;

    private Map<String, Integer> courseFreq;
    private Map<String, Course> courseMap;

    // private Map<String, User> users;
    private List<User> users;

    // private String[] commandsAndParams;

    private String mess;

    public String getMess() {
        return mess;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        for (Course i : this.courses) {

            courseMap.put(i.getId(), i);
            courseFreq.put(i.getId(), 0);
        }
    }

    public UserService() {

        // this.courses = courses;
        // this.commandsAndParams = commandsAndParams;

        this.courseFreq = new HashMap<>();
        this.courseMap = new HashMap<>();
        // this.users = new HashMap<>();
        this.users = new ArrayList<>();

        // this.registerUsers(this.commandsAndParams);
        // this.addUsertoMap();
    }

    public boolean addUsertoMap(String[] commandAndParams) {

        try {
            User user = returnsUserObject(commandAndParams);
            // users.put(user.getId(), user);
            users.add(user);

            this.mess = user.getId();
            return true;

        } catch (RuntimeException e) {
            // System.out.println(e.getMessage());
            this.mess = e.getMessage();
        }
        return false;
    }

    private User returnsUserObject(String[] commandAndParams) {

        User user = new User();

        if (commandAndParams.length == 3) {
            if (courseFreq.containsKey(commandAndParams[2])
                    && courseFreq.get(commandAndParams[2]) < courseMap.get(commandAndParams[2]).getMaxSlot()) {

                String name = getUserName(commandAndParams[1]);

                user.setId("REG-COURSE-" + name + "-" + courseMap.get(commandAndParams[2]).getCourseName());

                user.setUserName(commandAndParams[1]);

                user.setCourse(courseMap.get(commandAndParams[2]));

                user.setStatus("ACCEPTED");

                courseFreq.put(commandAndParams[2], courseFreq.get(commandAndParams[2]) + 1);

                // users.put(user.getId(), user);

            } else {
                throw new RuntimeException("COURSE_FULL_ERROR");
            }
        } else {
            throw new RuntimeException("INPUT_DATA_ERROR");
        }

        return user;
    }

    private String getUserName(String string) {
        int findIndex = string.indexOf("@");
        String userName = string.substring(0, findIndex);
        return userName;
    }

    public void printRegisteredUser() {
        for (User obj : users) {
            System.out.println(obj);
        }
        // for(Map.Entry<String, User> map : users.entrySet()){

        // System.out.println(map.getKey() + " " + map.getValue());
        // }
    }

    public ArrayList<User> allotCourse(String[] commandAndParams) {
        ArrayList<User> list = new ArrayList<>();
        // for (Map.Entry<String, User> map : users.entrySet())
        for (User obj : users) {

            // System.out.println(map.getKey() + " " + map.getValue());
            // User updateUser = map.getValue();

            if (obj.getCourse().getId().equals(commandAndParams[1])) {
                
                obj.setStatus("CONFIRMED");
                User updateUser = obj;
                list.add(updateUser);
            }

        }

        return list;

    }

    public boolean removeUser(String[] commandAndParams) {

        for (User userToDelete : users) {
            if (userToDelete.getId().equals(commandAndParams[1])  &&
             userToDelete.getStatus().equals("ACCEPTED")){
                users.remove(userToDelete);
                return true;
            }

        }
        return false;
    }

}
