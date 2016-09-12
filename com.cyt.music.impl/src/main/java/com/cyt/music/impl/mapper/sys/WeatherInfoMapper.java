package com.cyt.music.impl.mapper.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cyt.music.interfaces.pojo.common.WeatherInfo;
import com.cyt.music.interfaces.pojo.common.WeatherInfoExample;
public interface WeatherInfoMapper {
    int countByExample(WeatherInfoExample example);

    int deleteByExample(WeatherInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WeatherInfo record);

    int insertSelective(WeatherInfo record);

    List<WeatherInfo> selectByExample(WeatherInfoExample example);

    WeatherInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WeatherInfo record, @Param("example") WeatherInfoExample example);

    int updateByExample(@Param("record") WeatherInfo record, @Param("example") WeatherInfoExample example);

    int updateByPrimaryKeySelective(WeatherInfo record);

    int updateByPrimaryKey(WeatherInfo record);
}