package com.cyt.music.impl.logic.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyt.music.impl.logic.common.CommonLogic;
import com.cyt.music.impl.mapper.user.UserInfoMapper;
import com.cyt.music.interfaces.pojo.user.UserInfo;


@Component
public class demoLogic {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private CommonLogic commonLogic;
	
	public List<UserInfo> demoQuery(UserInfo userInfo) throws Exception {
		return userInfoMapper.demoTestQuery(userInfo);
	}
	
	public UserInfo editDemo(Integer id) throws Exception {
		return userInfoMapper.selectByPrimaryKey(id);
	}
	
	public void editItemsSubmit(UserInfo userInfo) throws Exception {
		userInfoMapper.updateByPrimaryKey(userInfo);
	}
}
