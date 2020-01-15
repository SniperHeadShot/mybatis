package com.bat.ibatis.po;

import lombok.Data;

/**
 * 系统角色 PO类
 *
 * @author ZhengYu
 * @version 1.0 2020/1/15 22:57
 **/
@Data
public class SysRolePO {

    private Long keyId;

    private String roleUuid;

    private String roleName;
}