package com.jnshu.service;

import com.jnshu.entities.Profession;

import java.util.List;

/**
 * created by 姚远 on 2017/9/5.
 */
public interface ProfessionService {
    List<Profession> selectProfessionAll();
    int selectNumber(Integer pid);
    List<Profession> getBefore();
    List<Profession> getAfter();
}
