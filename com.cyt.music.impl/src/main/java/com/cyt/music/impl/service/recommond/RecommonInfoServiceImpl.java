package com.cyt.music.impl.service.recommond;

import com.cyt.music.impl.logic.recommond.RecommonInfoLogic;
import com.cyt.music.interfaces.pojo.recommond.RecommondInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.recommond.RecommonInfoService;

import java.util.List;

/**
 * Created by Administrator on 2016/9/18.
 */
@Service
public class RecommonInfoServiceImpl implements RecommonInfoService {
	@Autowired
	private RecommonInfoLogic recommonInfoLogic;

	public List<RecommondInfo> queryRecommonInfo(RecommondInfo recommondInfo) throws Exception{
		 return recommonInfoLogic.queryRecommonInfo(recommondInfo);
	}

	public int addRecomInfo(RecommondInfo recommondInfo) throws Exception{
		 return recommonInfoLogic.addRecomInfo(recommondInfo);
	}
}
