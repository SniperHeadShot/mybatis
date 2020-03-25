package com.bat.ibatis.po;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统人员角色关系 PO类
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:45
 **/
@Data
@NoArgsConstructor
public class SysUserRoleRelPO {

    private Long keyId;

    private String userUuid;

    private String roleUuid;

    public SysUserRoleRelPO(String userUuid, String roleUuid) {
        this.userUuid = userUuid;
        this.roleUuid = roleUuid;
    }
}
