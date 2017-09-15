package com.jnshu.dao;

import com.jnshu.entities.Profession;

import java.util.List;

public interface ProfessionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);

    List<Profession> selectProfessionAll();

    List<Profession> getBefore();

    List<Profession> getAfter();

    int selectNumber(Integer pid);
}