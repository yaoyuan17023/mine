package com.jnshu.serviceImpl;

import com.jnshu.dao.ProfessionMapper;
import com.jnshu.entities.Profession;
import com.jnshu.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by 姚远 on 2017/9/5.
 */
@Service
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    private ProfessionMapper professionMapper;

    public List<Profession> selectProfessionAll(){
        List<Profession> professions=professionMapper.selectProfessionAll();
        return professions;
    }
    public int selectNumber( Integer pid){
        int i = professionMapper.selectNumber(pid);
        return i;
    }
    public List<Profession> getBefore(){
        List<Profession> professions =professionMapper.getBefore();
        return professions;
    }
    public List<Profession> getAfter(){
        List<Profession> professions =professionMapper.getAfter();
        return professions;
    }
}
