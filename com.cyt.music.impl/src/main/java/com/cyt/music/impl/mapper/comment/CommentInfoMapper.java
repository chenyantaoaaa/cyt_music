package com.cyt.music.impl.mapper.comment;


import java.util.List;

import com.cyt.music.interfaces.pojo.comment.CommentInfo;
import com.cyt.music.interfaces.pojo.comment.CommentInfoExample;
import org.apache.ibatis.annotations.Param;

public interface CommentInfoMapper {
    int countByExample(CommentInfoExample example);

    int deleteByExample(CommentInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommentInfo record);

    int insertSelective(CommentInfo record);

    List<CommentInfo> selectByExample(CommentInfoExample example);

    CommentInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommentInfo record,
            @Param("example") CommentInfoExample example);

    int updateByExample(@Param("record") CommentInfo record,
            @Param("example") CommentInfoExample example);

    int updateByPrimaryKeySelective(CommentInfo record);

    int updateByPrimaryKey(CommentInfo record);

    List<CommentInfo> queryCommentInfo(CommentInfo record);
}