package com.cyt.music.impl.mapper.music;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cyt.music.interfaces.pojo.music.MusicInfo;
import com.cyt.music.interfaces.pojo.music.MusicInfoExample;

public interface MusicInfoMapper {
    int countByExample(MusicInfoExample example);

    int deleteByExample(MusicInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MusicInfo record);

    int insertSelective(MusicInfo record);

    List<MusicInfo> selectByExample(MusicInfoExample example);

    MusicInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MusicInfo record, @Param("example") MusicInfoExample example);

    int updateByExample(@Param("record") MusicInfo record, @Param("example") MusicInfoExample example);

    int updateByPrimaryKeySelective(MusicInfo record);

    int updateByPrimaryKey(MusicInfo record);
    
    List<MusicInfo> queryMusicInfo(MusicInfo record);
}