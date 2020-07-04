package com.bat.ibatis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPO implements Serializable {

    private String userUuid;

    private String userName;

    private String password;

    private String phone;

    private String email;

    private Boolean accountExpired;

    private Boolean passwordExpired;

    private Boolean locked;

    private Boolean enabled;

    private String createTime;

    private String updateTime;
}