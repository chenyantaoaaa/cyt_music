package service.music;

import java.util.List;

import com.cyt.music.interfaces.pojo.music.MusicInfo;

public interface MusicInfoService {
	public List<MusicInfo> queryMusicInfo(MusicInfo musicInfo) throws Exception;
}
