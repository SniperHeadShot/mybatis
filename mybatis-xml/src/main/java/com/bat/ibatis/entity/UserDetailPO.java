package com.bat.ibatis.entity;

import lombok.Data;

@Data
public class UserDetailPO {

    private String userUuid;

    private String group;

    private String attributeKey;

    private String attributeValue;

    private String createTime;

    private String updateTime;
}