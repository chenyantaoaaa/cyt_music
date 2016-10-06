package com.cyt.music.impl.logic.recommond;

import com.cyt.music.impl.logic.common.CommonLogic;
import com.cyt.music.impl.mapper.recommond.RecommondInfoMapper;
import com.cyt.music.interfaces.pojo.recommond.RecommondInfo;
import com.cyt.music.interfaces.pojo.recommond.RecommondInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016/9/18.
 */
@Component
public class RecommonInfoLogic {

	@Autowired
	private RecommondInfoMapper recommondInfoMapper;

	@Autowired
	private CommonLogic commonLogic;

	public List<RecommondInfo> queryRecommonInfo(RecommondInfo recommondInfo) throws Exception{
		 return recommondInfoMapper.queryRecomInfo(recommondInfo);
	}

	public int addRecomInfo(RecommondInfo recommondInfo) throws Exception{
		Long id=commonLogic.getMaxCount(2);
		recommondInfo.setId(id.intValue());
		return recommondInfoMapper.insert(recommondInfo);
	}
}
