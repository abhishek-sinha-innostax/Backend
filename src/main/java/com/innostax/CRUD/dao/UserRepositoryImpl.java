package com.innostax.CRUD.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.innostax.CRUD.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private static final String INSERT_USER_QUERY = "INSERT INTO user (id, name, email, age) values(?,?,?,?)";
	private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE USER SET name=? WHERE id =?";
	private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM user WHERE id=?";
	private static final String DELETE_USER_BY_ID = "DELETE FROM user WHERE ID=?";
	private static final String GET_USERS_QUERY = "SELECT * FROM user order by id";

	@Autowired
	private JdbcTemplate jdbcTemplate ;

	@Override
	public User saveUser(User user) {
		jdbcTemplate.update(INSERT_USER_QUERY, user.getId(), user.getName(), user.getEmail(), user.getAge());
		return user;
	}

	@Override
	public User updateUser(User user) {
		jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, user.getName(), user.getId());
		return user;
	}

	@Override
	public User getById(int id) {
		return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum) -> {
			return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getInt("age"));
		},id);

	}

	@Override
	public String deleteById(int id) {
		jdbcTemplate.update(DELETE_USER_BY_ID, id);
		return "User with id= " + id + " got deleted sucessfully !";
	}

	@Override
	public List<User> allUsers() {

		return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> {
			return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getInt("age"));
		});
	}
	
	

}
