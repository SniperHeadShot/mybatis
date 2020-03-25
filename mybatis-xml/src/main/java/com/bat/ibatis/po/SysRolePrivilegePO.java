package com.bat.ibatis.po;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统角色权限关系 PO类
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:45
 **/
@Data
@NoArgsConstructor
public class SysRolePrivilegePO {

    private Long keyId;

    private String roleUuid;

    private String privilegeUuid;
}
