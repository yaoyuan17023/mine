package com.springmybatis.Mapper;

import com.springmybatis.model.StudentMod;

import java.util.List;

/**
 * created by 姚远 on 2017/8/8.
 */
public interface StudentMapper {
        StudentMod studySelect(StudentMod studentMod);
        int studyInsert(StudentMod studentMod);
        int studyUpdate(StudentMod studentMod);
        int studyDelete(String user_id);
        List<StudentMod> studentName();
}
