package com.bat.ibatis.po;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统角色 PO类
 *
 * @author ZhengYu
 * @version 1.0 2020/1/15 22:57
 **/
@Data
@NoArgsConstructor
public class SysRolePO {

    private Long keyId;

    private String roleUuid;

    private String roleName;

    private Integer enabled;

    private String createTime;

    private String updateTime;

    public SysRolePO(String roleUuid, String roleName, Integer enabled, String createTime) {
        this.roleUuid = roleUuid;
        this.roleName = roleName;
        this.enabled = enabled;
        this.createTime = createTime;
    }
}
