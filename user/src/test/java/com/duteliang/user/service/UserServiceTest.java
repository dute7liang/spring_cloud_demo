package com.duteliang.user.service;

import com.duteliang.UserApplicationTest;
import com.duteliang.user.repository.model.UserT;
import com.netflix.discovery.converters.Auto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: zl
 * @Date: 2018-12-25 15:39
 */
@Component
public class UserServiceTest extends UserApplicationTest {

	@Autowired
	private UserService userService;

	@Test
	public void list() {

		List<UserT> list = userService.list();


	}
}