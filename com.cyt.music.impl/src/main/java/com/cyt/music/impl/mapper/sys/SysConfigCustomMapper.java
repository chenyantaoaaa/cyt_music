package com.cyt.music.impl.mapper.sys;

import java.util.Date;

public interface SysConfigCustomMapper {
	Date queryMysqlDate();
	
	Long getMaxCount(int counterNo);
}
