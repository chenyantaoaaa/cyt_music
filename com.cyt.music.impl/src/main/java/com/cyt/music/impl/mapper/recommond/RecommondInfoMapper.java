package com.cyt.music.impl.mapper.recommond;

import com.cyt.music.interfaces.pojo.recommond.RecommondInfo;
import com.cyt.music.interfaces.pojo.recommond.RecommondInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RecommondInfoMapper {
    int countByExample(RecommondInfoExample example);

    int deleteByExample(RecommondInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RecommondInfo record);

    int insertSelective(RecommondInfo record);

    List<RecommondInfo> selectByExample(RecommondInfoExample example);

    RecommondInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RecommondInfo record,
            @Param("example") RecommondInfoExample example);

    int updateByExample(@Param("record") RecommondInfo record,
            @Param("example") RecommondInfoExample example);

    int updateByPrimaryKeySelective(RecommondInfo record);

    int updateByPrimaryKey(RecommondInfo record);

    List<RecommondInfo> queryRecomInfo (RecommondInfo record);
}