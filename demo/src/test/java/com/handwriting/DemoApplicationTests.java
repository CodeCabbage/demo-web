package com.handwriting;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.handwriting.entity.Department;
import com.handwriting.entity.Role;
import com.handwriting.entity.User;
import com.handwriting.repositories.DepartmentRepository;
import com.handwriting.repositories.RoleRepository;
import com.handwriting.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

private static Logger logger = LoggerFactory.getLogger(MySqlTest.class);
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	RoleRepository roleRepository;
	
	@Before
	public void initData(){
		userRepository.deleteAll();
		departmentRepository.deleteAll();
		roleRepository.deleteAll();
		
		Department department = new Department();
		department.setName("研发部");
		departmentRepository.save(department);
//		Assert.assertNotNull(department.getId());
		
		Role role = new Role();
		role.setName("admin");
		roleRepository.save(role);
//		Assert.assertNotNull(role.getId());
		
		User user = new User();
		user.setName("user");
		user.setCreatedate(new Date());
		userRepository.save(user);
//		Assert.assertNotNull(user.getId());
		
		List<Role> roles = roleRepository.findAll();
		Department departments =  departmentRepository.findAll().get(0);
//		Assert.assertNotNull(roles);
		user.setRolse(roles);
		user.setDepartment(departments);
		
		userRepository.save(user);
//		Assert.assertNotNull(user.getId());
	}
	
	@Test
	public void findPage(){
		Pageable pageable = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "id"));
		Page<User> page = userRepository.findAll(pageable);
//		Assert.assertNotNull(page);
		for(User user : page.getContent()){
			logger.info("====user==== user name:{}, department name:{}, role name:{}",
					user.getName(),user.getDepartment().getName(),user.getRolse().get(0).getName());
		}
	}

}
