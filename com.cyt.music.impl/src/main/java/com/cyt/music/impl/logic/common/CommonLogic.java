package com.cyt.music.impl.logic.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.cyt.music.common.exception.BizException;
import com.cyt.music.impl.mapper.sys.SysConfigCustomMapper;
import com.cyt.music.impl.mapper.sys.SysConfigMapper;
import com.cyt.music.impl.util.DateUtil;
import com.cyt.music.impl.util.webservice.WeatherUtil;
import com.cyt.music.interfaces.pojo.common.WeatherInfo;
import com.cyt.music.interfaces.pojo.system.SysConfig;
import com.cyt.music.interfaces.pojo.system.SysConfigExample;

@Component
public class CommonLogic {
	
	@Autowired
	private SysConfigCustomMapper sysConfigCustomMapper;
	
	@Autowired
	private SysConfigMapper sysConfigMapper;
	
	/**
	 * 获取数据库时间
	 * @return
	 * @throws  BizException
	 */
	public Long[] getNowTime() throws BizException{
		Date now = sysConfigCustomMapper.queryMysqlDate();
		Long nowLong = DateUtil.getLongDateTime(now);
		return new Long[]{nowLong / 1000000, nowLong % 1000000};
	}
	
	/**
	 * 获取流水号
	 * @return
	 * @throws BizException
	 */
	public Long getMaxCount(int counterNo) throws BizException{
		
		return sysConfigCustomMapper.getMaxCount(counterNo);
	}
	
	/**
	 * 当前城市天气
	 * @return
	 * @throws BizException
	 */
	public WeatherInfo getWeather(String city) throws BizException{
		if(city==null || "".equals(city)){
			city="北京";
		}

		String [] strA=WeatherUtil.getWeather(city);
		WeatherInfo weatherInfo=new WeatherInfo();

		
		if(strA!=null){
			String Overview = strA[0];
			String temperature = "";
			String wind = "";
			if(strA[1]!=null) {
				String details = strA[1];
				details = details.replaceAll("；", "：");
				temperature = details.split("：")[2];
				wind = details.split("：")[4];
			}

			weatherInfo.setOverview(Overview);
			weatherInfo.setTemperature(temperature);
			weatherInfo.setWind(wind);
		}
		return weatherInfo;
	}
}
