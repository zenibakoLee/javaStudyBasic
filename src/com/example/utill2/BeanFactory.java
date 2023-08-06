package com.example.utill2;

public class BeanFactory {
    //2. 자기 자신 인스턴스를 참조하는 static한 필드를 선언
    private static  BeanFactory instance = new BeanFactory();
    //1. private constructor를 만든다. 외부에서 인스턴스 생성 불가.
    private  BeanFactory(){}
    // 싱글톤 패턴
    public  static BeanFactory getInstance(){
        return instance;
    }
}
