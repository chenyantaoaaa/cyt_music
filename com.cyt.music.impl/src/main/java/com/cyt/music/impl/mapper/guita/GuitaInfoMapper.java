package com.cyt.music.impl.mapper.guita;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cyt.music.interfaces.pojo.guita.GuitaInfo;
import com.cyt.music.interfaces.pojo.guita.GuitaInfoExample;

public interface GuitaInfoMapper {
    int countByExample(GuitaInfoExample example);

    int deleteByExample(GuitaInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GuitaInfo record);

    int insertSelective(GuitaInfo record);

    List<GuitaInfo> selectByExample(GuitaInfoExample example);

    GuitaInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GuitaInfo record, @Param("example") GuitaInfoExample example);

    int updateByExample(@Param("record") GuitaInfo record, @Param("example") GuitaInfoExample example);

    int updateByPrimaryKeySelective(GuitaInfo record);

    int updateByPrimaryKey(GuitaInfo record);
    
    List<GuitaInfo> queryGuitaInfo(GuitaInfo record);
    
    int queryGuitaInfoCount (GuitaInfo record);
}