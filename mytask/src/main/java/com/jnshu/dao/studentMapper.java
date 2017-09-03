package com.jnshu.dao;

import com.jnshu.entities.student;

public interface studentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(student record);

    int insertSelective(student record);

    student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(student record);

    int updateByPrimaryKey(student record);
}