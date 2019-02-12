package com.mn.contactstore.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mn.contactstore.config.SpringRootConfig;
import com.mn.contactstore.dao.UserDao;
import com.mn.contactstore.dao.UserDaoImpl;
import com.mn.contactstore.domain.User;

/**
 * @author Md Nazish
 *
 */
public class UserTestCases {

	public static void main(String[] args) {
		// create IOC container and load the configuration
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);

		UserDao userDao = context.getBean("userDao", UserDaoImpl.class);

		/*// create user obj
		// TODO : these all data come from UI Registration-Form
		User user = new User();
		user.setName("Attaullah");
		user.setPhone("8736479937");
		user.setEmail("atta@gmail.com");
		user.setAddress("Ansansole , Kolkata");
		user.setLoginName("atta");
		user.setPassword("atta123");
		user.setRole(1);// Admin Role
		user.setLoginStatus(1);// Active

		// insert into DB
		userDao.addUser(user);
		System.out.println("----------User created Successfully---------------------");*/
		
		// TODO : these all data come from UI Edit User Profile Page
		/*User user = new User();
		user.setUserId(3);
		user.setName("Attaullah Khan");
		user.setPhone("8736479937");
		user.setEmail("khan@gmail.com");
		user.setAddress("Ansansole , Kolkata India");
		user.setRole(2);// Admin Role
		user.setLoginStatus(1);// Active
		
		// update User data
		userDao.updateUser(user);
		System.out.println("----------User detail is updated Successfully---------------------");
		*/
		
		// delete user by its id
		/*userDao.deleteUserById(2);
		System.out.println("----------User is deleted by its ID ---------------------");*/
		
		// delete user record
		/*User user = new User();
		user.setUserId(3);
		userDao.deleteUser(user);
		System.out.println("----------User deleted Sucessfully ---------------------");*/
		
		// fetch user record by it's ID
		/*User user = userDao.getUserById(1);
		
		System.out.println("User ID: "+user.getUserId());
		System.out.println("Name   : "+user.getName());
		System.out.println("Email  : "+user.getEmail());
		System.out.println("Phone  : "+user.getPhone());
		System.out.println("Address: "+user.getAddress());
		System.out.println("Login Name: "+user.getLoginName());
		System.out.println("Login Status: "+user.getLoginStatus());
		System.out.println("User Role : "+user.getRole());
		*/
		
		// fetch all user record
		/*List<User> userList = userDao.findAll();
		 
		if(userList.isEmpty() != true) {
		for (User user : userList) {
			System.out.println("User ID: "+user.getUserId());
			System.out.println("Name   : "+user.getName());
			System.out.println("Email  : "+user.getEmail());
			System.out.println("Phone  : "+user.getPhone());
			System.out.println("Address: "+user.getAddress());
			System.out.println("Login Name: "+user.getLoginName());
			System.out.println("Login Status: "+user.getLoginStatus());
			System.out.println("User Role : "+user.getRole());
			
			System.out.println("=====================================================");
			}
		}else{
			System.out.println("============= No Record Found =======================");
		}
		*/
		
		// fetch records by passing properties
		
		//List<User> userList = userDao.findByProperty("user_id", 1); // Case-1
		List<User> userList = userDao.findByProperty("name", "ak");// Case-2
		//List<User> userList = userDao.findByProperty("role", 2); // Case-3

		if(userList.isEmpty() != true) {
		for (User user : userList) {
			System.out.println("User ID: "+user.getUserId());
			System.out.println("Name   : "+user.getName());
			System.out.println("Email  : "+user.getEmail());
			System.out.println("Phone  : "+user.getPhone());
			System.out.println("Address: "+user.getAddress());
			System.out.println("Login Name: "+user.getLoginName());
			System.out.println("Login Status: "+user.getLoginStatus());
			System.out.println("User Role : "+user.getRole());
			
			System.out.println("=====================================================");
		}
		}else {
			System.out.println("============== No Record Found ======================");
		}
	}

}
