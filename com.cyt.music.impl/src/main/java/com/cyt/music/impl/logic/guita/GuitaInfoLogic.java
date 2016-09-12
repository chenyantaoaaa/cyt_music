package com.cyt.music.impl.logic.guita;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyt.music.impl.logic.common.CommonLogic;
import com.cyt.music.impl.mapper.guita.GuitaInfoMapper;
import com.cyt.music.interfaces.pojo.guita.GuitaInfo;
import com.cyt.music.interfaces.pojo.guita.GuitaInfoExample;

@Component
public class GuitaInfoLogic {
	
	@Autowired
	private GuitaInfoMapper  guitaInfoMapper;
	
	@Autowired
	private CommonLogic commonLogic;

	public List<GuitaInfo> queryGuitaInfo(GuitaInfo guitaInfo) throws Exception {
//		GuitaInfoExample example=new GuitaInfoExample();
//		List<Integer> values=new ArrayList<Integer>();
//		values.add(1);
//		values.add(2);
//		example.createCriteria().andIdIn(values);
//		return guitaInfoMapper.selectByExample(example);
		return guitaInfoMapper.queryGuitaInfo(guitaInfo);
	}
	
	public void addGuitaInfo(GuitaInfo guitaInfo) throws Exception {	
		
		Long id=commonLogic.getMaxCount(1);
		guitaInfo.setId(id.intValue());
		guitaInfoMapper.insert(guitaInfo);
	}
}
