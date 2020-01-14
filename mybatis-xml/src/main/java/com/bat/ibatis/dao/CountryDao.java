package com.bat.ibatis.dao;

import com.bat.ibatis.po.CountryPO;

import java.util.List;

/**
 * CountryDao
 *
 * @author ZhengYu
 * @version 1.0 2020/1/14 22:58
 **/
public interface CountryDao {

    List<CountryPO> getCountryList();
}
