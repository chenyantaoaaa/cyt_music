package service.recommond;

import com.cyt.music.interfaces.pojo.recommond.RecommondInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/9/18.
 */
public interface RecommonInfoService {
	public List<RecommondInfo> queryRecommonInfo(RecommondInfo recommondInfo) throws Exception;

	public int addRecomInfo(RecommondInfo recommondInfo) throws Exception;
}
