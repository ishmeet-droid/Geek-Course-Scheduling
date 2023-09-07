package com.example.geektrust.services;

import java.util.List;

public class HandleCommands {

    private List<String> listOfCommands;

    public HandleCommands(List<String> listOfCommands){

        this.listOfCommands = listOfCommands;
    }

    public void getCommands() {

        for(String i : listOfCommands){
            System.out.println(i);
        }
    }

    public void operateCommands() {

         for(String i : listOfCommands){
            
            String[] commandAndParams= i.split("\\s+");

            // for(String j : commandAndParams){
            // System.out.println(j);
            // }
            
            switch(commandAndParams[0]){

                case "ADD-COURSE-OFFERING":
                    // new AddCourse(commandAndParams).printListOfCourses();
                    System.out.println(new AddCourse(commandAndParams).getMess());
                break;

            }

        }


    }
    
}
