package com.cyt.music.impl.service.user;

import com.cyt.music.impl.logic.user.UserLogic;
import com.cyt.music.interfaces.pojo.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.user.UserService;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/27.
 */
@Service
public class userServiceImpl implements UserService {

	@Autowired
	private UserLogic userLogic;

	@Override
	public UserInfo getByUserName(String userName) {
		return userLogic.getByUserName(userName);
	}

	@Override
	public Set<String> getRoles(String userName) {
		return userLogic.getRoles(userName);
	}

	@Override
	public Set<String> getPermissions(String userName) {
		return userLogic.getPermissions(userName);
	}
}
