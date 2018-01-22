/**
 * 
 */
package com.study.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.file.dao.IUserDao;
import com.study.file.entry.User;

/**
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	/* (non-Javadoc)
	 * @see com.study.file.service.IUserService#addUser(com.study.file.entry.User)
	 * @param user
	 */
	@Autowired
	private IUserDao userDao;
	@Override
	public void addUser(User user) {
		userDao.addUser(user);

	}

}
