package com.bat.ibatis.po;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 系统人员 PO类
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:45
 **/
@Data
public class SysUserPO {

    private Long keyId;

    private String userUuid;

    private String username;

    private String password;

    private String email;

    private String phone;

    private JSONObject extInfo;

    private String img;

    private String createTime;

    private String updateTime;
}
