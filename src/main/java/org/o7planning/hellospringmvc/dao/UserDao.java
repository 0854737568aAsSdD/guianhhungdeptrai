package org.o7planning.hellospringmvc.dao;

import java.util.List;

import org.o7planning.hellospringmvc.model.User;

public interface UserDao {
public void addUser(User user);
public void updateUser(User user);
public void deleteUser(int id);
public User getUserbyId(int id );
public List<User> getAllusers();
}
