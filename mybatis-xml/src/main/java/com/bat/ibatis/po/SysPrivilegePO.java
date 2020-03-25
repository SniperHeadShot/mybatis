package com.bat.ibatis.po;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 资源权限 PO类
 *
 * @author ZhengYu
 * @version 1.0 2020/1/15 22:57
 **/
@Data
@NoArgsConstructor
public class SysPrivilegePO {

    private Long keyId;

    private String privilegeUuid;

    private String privilegeName;

    private String privilegeUrl;
}
