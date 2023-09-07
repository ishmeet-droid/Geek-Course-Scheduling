package com.example.geektrust.services;

import java.util.List;

import com.example.geektrust.models.Course;

public class HandleCommands {

    private List<String> listOfCommands;
    private List<Course> courses;

    public HandleCommands(List<String> listOfCommands){

        this.listOfCommands = listOfCommands;
    }

    public void getCommands() {

        for(String i : listOfCommands){
            System.out.println(i);
        }
    }

    public void operateCommands() {

         AddCourse addCourse = new AddCourse();
         RegisterUser usersStatus = new RegisterUser();

         for(String i : listOfCommands){
            
            String[] commandAndParams= i.split("\\s+");

            // for(String j : commandAndParams){
            // System.out.println(j);
            // }
            
            switch(commandAndParams[0]){

                case "ADD-COURSE-OFFERING":
                    // new AddCourse(commandAndParams).printListOfCourses();
                    // AddCourse addCourse = new AddCourse(commandAndParams);
                    addCourse.addCourseToList(commandAndParams);
                    courses = addCourse.getCourses();
                    usersStatus.setCourses(courses);
                    System.out.println(addCourse.getMess());
                break;
                case "REGISTER":
                    // new RegisterUser(commandAndParams, this.courses).printRegisteredUser();
                    // System.out.println(new RegisterUser(commandAndParams, this.courses).getMess());
                    // usersStatus.setCourses(courses);
                    usersStatus.setCommandsAndParams(commandAndParams);
                    usersStatus.addUsertoMap();
                    System.out.println(usersStatus.getMess());
                break;
            }

        }


    }
    
}
