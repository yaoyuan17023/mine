package com.jnshu.dao;

import com.jnshu.entities.profession;

import java.util.List;

public interface professionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(profession record);

    int insertSelective(profession record);

    profession selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(profession record);

    int updateByPrimaryKey(profession record);

    List<profession> selectProfessionAll();
}