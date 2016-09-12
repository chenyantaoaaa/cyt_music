package com.cyt.music.interfaces.pojo.music;

import java.util.ArrayList;
import java.util.List;

public class MusicResult {
	//结果集
	private List musics = new ArrayList();
	
	private int start;
	
	private String uploader;

	public List getMusics() {
		return musics;
	}

	public void setMusics(List musics) {
		this.musics = musics;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
}
