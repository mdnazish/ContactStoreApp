package com.mn.contactstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mn.contactstore.dao.AbstractBaseDao;
import com.mn.contactstore.dao.UserDao;
import com.mn.contactstore.domain.User;
import com.mn.contactstore.exception.UserBlockedException;
import com.mn.contactstore.rowmapper.UserRowMapper;

/**
 * @author Md Nazish
 *
 */
@Service("userService")
public class UserServiceImpl extends AbstractBaseDao implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean register(User user) {
		if (user != null) {
			userDao.addUser(user);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		String sql = "SELECT user_id, name, phone, email, address, role, login_status, login_name"
				+ " FROM user WHERE login_name=:loginName AND password=:pwd";
		Map<String, String> map = new HashMap<>();
		map.put("loginName", loginName);
		map.put("pwd", password);
		try {
			User user = getNamedParameterJdbcTemplate().queryForObject(sql, map, new UserRowMapper());
			// Check user is active or blocked
			if (user.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
				throw new UserBlockedException("Your accout has been blocked. Contact Your Admin.");
			} else {
				return user;
			}
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub

	}

}
