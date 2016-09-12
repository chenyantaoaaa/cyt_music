package com.cyt.music.impl.service.guita;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyt.music.impl.logic.guita.GuitaInfoLogic;
import com.cyt.music.impl.mapper.guita.GuitaInfoMapper;
import com.cyt.music.interfaces.pojo.guita.GuitaInfo;

import service.guita.GuitaInfoService;

@Service
public class GuitaInfoServiceImpl implements GuitaInfoService{

	@Autowired
	private GuitaInfoLogic guitaInfoLogic;
	
	@Autowired
	private GuitaInfoMapper guitaInfoMapper;
	
	@Override
	public List<GuitaInfo> queryGuitaInfo(GuitaInfo guitaInfo) throws Exception {
		return guitaInfoLogic.queryGuitaInfo(guitaInfo);
	}

	@Override
	public int queryGuitaInfoCount(GuitaInfo guitaInfo) throws Exception {
		return guitaInfoMapper.queryGuitaInfoCount(guitaInfo);
	}

	@Override
	public void addGuitaInfoCount(GuitaInfo guitaInfo) throws Exception {
		 guitaInfoLogic.addGuitaInfo(guitaInfo);
	}
}
