package com.example.io;

import java.util.Iterator;
import java.util.List;

public interface UserService {
    public boolean addUser(User user);
    public boolean updateUser(User user);

    public boolean deleteUser(String email);

    public Iterator<User> getUsers();

    // email에 해당하는 회원정보 있을 시 0보다 큰 인덱스 반환
    public int findIndex(String email);
    public boolean exists(String email);
}
