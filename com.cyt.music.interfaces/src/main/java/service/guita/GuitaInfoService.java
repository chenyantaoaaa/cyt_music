package service.guita;

import java.util.List;

import com.cyt.music.interfaces.pojo.guita.GuitaInfo;

public interface GuitaInfoService {
	public List<GuitaInfo> queryGuitaInfo(GuitaInfo guitaInfo) throws Exception;
	
	public int queryGuitaInfoCount(GuitaInfo guitaInfo) throws Exception;
	
	public void addGuitaInfoCount(GuitaInfo guitaInfo) throws Exception;
}
