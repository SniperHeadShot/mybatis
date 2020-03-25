package com.bat.ibatis.po;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统人员 PO类
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:45
 **/
@Data
@NoArgsConstructor
public class SysUserPO {

    private Long keyId;

    private String userUuid;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String createTime;

    private String updateTime;

    public SysUserPO(String userUuid, String username, String password, String createTime) {
        this.userUuid = userUuid;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
    }
}
