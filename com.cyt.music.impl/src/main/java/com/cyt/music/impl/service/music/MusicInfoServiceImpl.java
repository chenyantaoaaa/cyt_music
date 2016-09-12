package com.cyt.music.impl.service.music;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyt.music.impl.logic.music.MusicInfoLogic;
import com.cyt.music.interfaces.pojo.music.MusicInfo;

import service.music.MusicInfoService;

@Service
public class MusicInfoServiceImpl implements MusicInfoService{

	@Autowired
	private MusicInfoLogic musicInfoLogic;
	
	@Override
	public List<MusicInfo> queryMusicInfo(MusicInfo musicInfo) throws Exception {
		return musicInfoLogic.queryMusicInfo(musicInfo);
	}

}
