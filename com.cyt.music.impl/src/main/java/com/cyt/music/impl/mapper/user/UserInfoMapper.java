package com.cyt.music.impl.mapper.user;

import java.util.List;

import com.cyt.music.interfaces.pojo.user.UserInfo;
import com.cyt.music.interfaces.pojo.user.UserInfoExample;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
    int countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInfo record,
            @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record,
            @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}