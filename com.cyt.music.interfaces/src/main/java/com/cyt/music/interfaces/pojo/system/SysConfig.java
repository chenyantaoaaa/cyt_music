package com.cyt.music.interfaces.pojo.system;

public class SysConfig {
    private Integer configNo;

    private String configName;

    private String configInfo;

    private String remark;

    public Integer getConfigNo() {
        return configNo;
    }

    public void setConfigNo(Integer configNo) {
        this.configNo = configNo;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public String getConfigInfo() {
        return configInfo;
    }

    public void setConfigInfo(String configInfo) {
        this.configInfo = configInfo == null ? null : configInfo.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}