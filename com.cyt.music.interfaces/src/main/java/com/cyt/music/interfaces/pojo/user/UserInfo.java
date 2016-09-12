package com.cyt.music.interfaces.pojo.user;

import com.cyt.music.interfaces.pojo.common.PageInfo;

public class UserInfo {
    private Integer id;

    private String username;

    private String userstatus;
    
    private PageInfo pageInfo;

    public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username
				+ ", userstatus=" + userstatus + "]";
	}

	public String getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus == null ? null : userstatus.trim();
    }
}