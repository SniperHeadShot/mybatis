package com.bat.ibatis.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 系统人员 Dao 查询条件
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:45
 **/
@Data
@NoArgsConstructor
public class SysUserCondition {

    private String userUuid;

    private String userName;

    private String email;

    private String phone;

    private String beginTime;

    private String endTime;

    /**
     * 账户可能是 username/email/phone
     */
    private String accountName;

    /**
     * 用户 UUID 集合
     */
    private List<String> userUuidList;
}
