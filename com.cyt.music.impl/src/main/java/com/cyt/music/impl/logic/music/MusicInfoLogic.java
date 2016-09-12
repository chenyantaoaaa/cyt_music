package com.cyt.music.impl.logic.music;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyt.music.impl.mapper.music.MusicInfoMapper;
import com.cyt.music.interfaces.pojo.music.MusicInfo;

@Component
public class MusicInfoLogic {
	
	@Autowired
	private MusicInfoMapper musicInfoMapper;
	
	public List<MusicInfo> queryMusicInfo(MusicInfo musicInfo) throws Exception {
		return  musicInfoMapper.queryMusicInfo(musicInfo);
	}
}
