package com.cyt.music.impl.service.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyt.music.impl.logic.demo.demoLogic;
import com.cyt.music.impl.mapper.user.UserInfoMapper;
import com.cyt.music.interfaces.pojo.user.UserInfo;

import service.user.demoService;

@Service
public class demoServiceImpl implements demoService{

	@Autowired
	private demoLogic demoLogic;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public List<UserInfo> demoQuery(UserInfo userInfo) throws Exception {
		return demoLogic.demoQuery(userInfo);
	}
	
	@Override
	public UserInfo editDemo(Integer id) throws Exception {
		return demoLogic.editDemo(id);
	}

	@Override
	public void editItemsSubmit(UserInfo userInfo) throws Exception {
		demoLogic.editItemsSubmit(userInfo);		
	}

}
