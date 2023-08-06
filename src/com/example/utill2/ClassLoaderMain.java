package com.example.utill2;

import com.example.Bus;
import com.example.Car;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderMain {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        /*
        a() 메소드를 갖고있는 클래스가 있다.
        이 클래스 이름은 아직 모르겠다.
        나중에 이 클래스 이름은 알려주겠다.
        일단 그렇게 가정하고 a()메소드 들어오면 실행할 수 있는 코드를 작성하라.
         */
//        Bus b1 = new Bus();
//        b1.a();

        // CLASSPATH에서 className에 해당하는 클래스 정보를 찾아
        // 그 정보를 clazz가 참조하도록 한다.
        String className = "com.example.MyHome";
        Class clazz = Class.forName(className);
        Object o = clazz.newInstance();
//        Car b = (Car)o;
//        b.a();

        try {
            Method m = clazz.getDeclaredMethod("a",null); // a라는 메소드정보를 갖고있는 메소드를 반환
            m.invoke(o,null); // Object o 가 참조하는 객체의 m메소드를 실행
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
