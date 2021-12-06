package org.o7planning.hellospringmvc.services.impl;

import java.util.List;

import org.o7planning.hellospringmvc.dao.UserDao;
import org.o7planning.hellospringmvc.dao.impl.UserDaoImpl;
import org.o7planning.hellospringmvc.model.User;
import org.o7planning.hellospringmvc.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	UserDao userDao;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
	}

	@Override
	public User getUserbyId(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserbyId(id);
	}

	@Override
	public List<User> getAllusers() {
		return userDao.getAllusers();
	}

}
