package com.bat.ibatis.enums;

/**
 * 系统人员类型枚举
 *
 * @author ZhengYu
 * @version 1.0 2020/3/26 16:32
 **/
public enum SysEnableEnum {

    ENABLE(1, 0, "禁用[某项不生效]"),
    DIS_ENABLE(2, 1, "启用[某项生效]"),
    ;

    SysEnableEnum(Integer index, Integer code, String value) {
        this.index = index;
        this.code = code;
        this.value = value;
    }

    private Integer index;
    private Integer code;
    private String value;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}


