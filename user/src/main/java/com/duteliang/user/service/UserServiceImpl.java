package com.duteliang.user.service;

import com.duteliang.user.repository.dao.UserTMapper;
import com.duteliang.user.repository.model.UserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: zl
 * @Date: 2018-12-25 15:35
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserTMapper userTMapper;

	@Override
	public List<UserT> list() {
		return userTMapper.selectList(null);
	}
}
