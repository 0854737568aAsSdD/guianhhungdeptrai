package org.o7planning.hellospringmvc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.o7planning.hellospringmvc.dao.UserDao;
import org.o7planning.hellospringmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void addUser(User user) {
		String sql = "INSERT INTO nguoidung(Name,Email) VALUE (?,?)";
		jdbcTemplate.update(sql, user.getName(), user.getGender());
	}

	@Override
	public void updateUser(User user) {
		String sql = "INSERT nguoidung set Name=? and Email=? where Id=?";
		jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getId());
	}

	@Override
	public void deleteUser(int id) {
		String sql = "DELELE from nguoidung where Id=?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public User getUserbyId(int id) {
		String sql = "Select * from nguoidung where Id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("Name"));
				user.setEmail(rs.getString("Email"));
				return user;
			}
		});
	}

	@Override
	public List<User> getAllusers() {
		String sql = "Select * from nguoidung";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("Id"));
				user.setName(rs.getString("Name"));
				user.setEmail(rs.getString("Email"));
				return user;
			}
		});

	}

}
