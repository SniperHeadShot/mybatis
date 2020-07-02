package com.bat.ibatis.entity;

import lombok.Data;

import java.util.List;

/**
 * {@link UserPO} 删除条件
 *
 * @author ZhengYu
 * @version 1.0 2020/7/2 23:43
 **/
@Data
public class UserDelete {

    private String userUuid;

    private List<String> userUuidList;
}
