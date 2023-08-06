package com.example.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 메모리상에 User정보를 관리하는 클래스
public class UserServiceInMemory implements UserService{
    private List<User> users;

    public UserServiceInMemory() {
        this.users = new ArrayList<>();
    }

    public UserServiceInMemory(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean addUser(User user) {
        users.add(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        boolean deleteFlag = deleteUser(user.getEmail());
        if(deleteFlag){
            users.add(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteUser(String email) {
        int foundIndex = findIndex(email);
        if(foundIndex>-1){
            users.remove(foundIndex);
            return true;
        }else{
            return false;
        }
    }

    /*
    users iterator로 리턴하여 수정 불가하게
     */
    @Override
    public Iterator<User> getUsers() {
        return users.iterator();
    }

    @Override
    public boolean exists(String email) {
      return  (findIndex(email)!=-1);
    }

    @Override
    public int findIndex(String email) {
        int foundIndex = -1;
        for(int i=0;i<users.size();i++){
            if(users.get(i).getEmail().equals(email)){
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }
}
