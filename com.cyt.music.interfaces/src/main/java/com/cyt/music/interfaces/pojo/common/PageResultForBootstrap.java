package com.cyt.music.interfaces.pojo.common;

import java.util.ArrayList;
import java.util.List;

import com.cyt.music.interfaces.pojo.user.UserInfo;

public class PageResultForBootstrap {

	private PageInfo pageInfo;
	
	//结果集
	private List rows = new ArrayList();
	
	private Integer total;

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}


	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
