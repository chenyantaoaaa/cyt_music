package com.cyt.music.impl.util;

import java.text.DecimalFormat;

public class RunUtil {
    //流水号前补0  传入(1,"00000") 得到"00001"
  	public static String patchZero(Long sn,String formatStr){
  		if(null == sn){
  			return "0";
  		}
  		DecimalFormat df = new DecimalFormat(formatStr);
  		return df.format(sn);
  	}
}
