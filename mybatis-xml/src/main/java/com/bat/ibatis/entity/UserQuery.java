package com.bat.ibatis.entity;

import lombok.Data;

import java.util.List;

/**
 * {@link UserPO} 列表查询条件
 *
 * @author ZhengYu
 * @version 1.0 2020/7/2 23:43
 **/
@Data
public class UserQuery {

    private String userUuid;

    private List<String> userUuidList;

    private String userName;

    private String phone;

    private String email;
}
