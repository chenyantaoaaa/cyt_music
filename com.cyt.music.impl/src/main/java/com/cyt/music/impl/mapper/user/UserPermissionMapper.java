package com.cyt.music.impl.mapper.user;

import java.util.List;

import com.cyt.music.interfaces.pojo.user.UserPermission;
import com.cyt.music.interfaces.pojo.user.UserPermissionExample;
import org.apache.ibatis.annotations.Param;

public interface UserPermissionMapper {
    int countByExample(UserPermissionExample example);

    int deleteByExample(UserPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPermission record);

    int insertSelective(UserPermission record);

    List<UserPermission> selectByExample(UserPermissionExample example);

    UserPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPermission record,
            @Param("example") UserPermissionExample example);

    int updateByExample(@Param("record") UserPermission record,
            @Param("example") UserPermissionExample example);

    int updateByPrimaryKeySelective(UserPermission record);

    int updateByPrimaryKey(UserPermission record);
}