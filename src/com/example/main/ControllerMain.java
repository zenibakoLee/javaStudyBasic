package com.example.main;


import com.example.framework.Controller;
import com.example.myProject.FirstController;

public class ControllerMain {
    public static void main(String[] args){
        Controller c1 = new FirstController();
        c1.execute();
    }
}
