package com.example.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
file에서 List<User>를 읽어오거나 저장하는 기능
 */
public class UserDao {
    private String filename;

    public UserDao(String filename) {
        this.filename = filename;
    }

    public void saveUser(Iterator<User> iter){
        List<User> users = new ArrayList<>();
        while(iter.hasNext()){
         users.add(iter.next());
        }
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(users);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public List<User> getUsers(){
        File file = new File(filename);
        if(!file.exists()){
            return new ArrayList<>();
        }
        List<User> list = null;
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            list = (List<User>)in.readObject();
        }catch(Exception e){e.printStackTrace();}
        return list;
    }
}
