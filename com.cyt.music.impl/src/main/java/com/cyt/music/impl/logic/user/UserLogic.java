package com.cyt.music.impl.logic.user;

import com.cyt.music.impl.mapper.user.UserCustomMapper;
import com.cyt.music.interfaces.pojo.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/27.
 */
@Component
public class UserLogic {
	@Autowired
	private UserCustomMapper userCustomMapper;

	public UserInfo getByUserName(String userName) {
		return userCustomMapper.getByUserName(userName);
	}

	public Set<String> getRoles(String userName) {
		return userCustomMapper.getRoles(userName);
	}

	public Set<String> getPermissions(String userName) {
		return userCustomMapper.getPermissions(userName);
	}
}
