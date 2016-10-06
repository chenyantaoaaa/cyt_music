package com.cyt.music.interfaces.pojo.user;

public class UserPermission {
    private Integer id;

    private String permissonname;

    private Integer roleid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissonname() {
        return permissonname;
    }

    public void setPermissonname(String permissonname) {
        this.permissonname = permissonname == null ? null : permissonname.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}