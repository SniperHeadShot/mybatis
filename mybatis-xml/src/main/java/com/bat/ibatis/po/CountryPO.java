package com.bat.ibatis.po;

/**
 * Country PO类
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:45
 **/
public class CountryPO {

    private Long id;

    private String countryName;

    private String countryCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
