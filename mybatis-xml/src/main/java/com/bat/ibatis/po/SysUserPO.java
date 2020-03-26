package com.bat.ibatis.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private String userName;

    private String userType;

    private String password;

    private String email;

    private String phone;

    private String createTime;

    private String updateTime;

    private List<SysRolePO> sysRoleList;

    public SysUserPO(String userUuid, String userName, String userType, String password, String email, String phone, String createTime) {
        this.userUuid = userUuid;
        this.userName = userName;
        this.userType = userType;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.createTime = createTime;
    }


}
