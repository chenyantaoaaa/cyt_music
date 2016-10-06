package com.cyt.music.impl.mapper.comment;

import com.cyt.music.interfaces.pojo.comment.TopicInfo;
import com.cyt.music.interfaces.pojo.comment.TopicInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicInfoMapper {
    int countByExample(TopicInfoExample example);

    int deleteByExample(TopicInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TopicInfo record);

    int insertSelective(TopicInfo record);

    List<TopicInfo> selectByExample(TopicInfoExample example);

    TopicInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TopicInfo record,
            @Param("example") TopicInfoExample example);

    int updateByExample(@Param("record") TopicInfo record,
            @Param("example") TopicInfoExample example);

    int updateByPrimaryKeySelective(TopicInfo record);

    int updateByPrimaryKey(TopicInfo record);

    List<TopicInfo> queryTopicInfo(TopicInfo record);
}