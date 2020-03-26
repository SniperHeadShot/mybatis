package com.bat.ibatis.enums;

/**
 * 系统人员类型枚举
 *
 * @author ZhengYu
 * @version 1.0 2020/3/26 16:32
 **/
public enum SysUserTypeEnum {

    SYSTEM(1, "system", "系统人员"),
    VISITOR(2, "visitor", "游客"),
    ;

    SysUserTypeEnum(Integer index, String code, String value) {
        this.index = index;
        this.code = code;
        this.value = value;
    }

    private Integer index;
    private String code;
    private String value;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }}
