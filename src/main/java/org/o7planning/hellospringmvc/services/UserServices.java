package org.o7planning.hellospringmvc.services;

import java.util.List;

import org.o7planning.hellospringmvc.model.User;

public interface UserServices {
	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);

	public User getUserbyId(int id);

	public List<User> getAllusers();

}
