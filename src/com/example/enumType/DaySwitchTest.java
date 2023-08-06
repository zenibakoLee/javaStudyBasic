package com.example.enumType;

public class DaySwitchTest {
    public static void main(String[] args) {
        Day day = Day.SUNDAY;
        switch (day){
            case SUNDAY :
                System.out.println("일요일");
                break;
            default:
                System.out.println("default case");
        }
    }
}
