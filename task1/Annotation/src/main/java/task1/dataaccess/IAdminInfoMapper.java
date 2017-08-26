package task1.dataaccess;


import task1.beans.AdminInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * created by 姚远 on 2017/8/15.
 */
public interface IAdminInfoMapper {
    @Select("select * from student where id = #{id}")
    public AdminInfo selectById(int id);
    @Select("select * from student")
    public List<AdminInfo> getAll();
    @Insert("insert into student(name,qq,type,time,school,number,link,hope,referrer,from_where,id,create_at,update_at) values(#{name},#{qq},#{type},#{time},#{school},#{number},#{link},#{hope},#{referrer},#{from_where},#{id},#{create_at},#{update_at})")
    public int add(AdminInfo student);
    @Update("update student set name=#{name},update_at=#{update_at} where id=#{id}")
    public int updateById(int id);
    @Delete("delete from student where id = #{id}")
    public int deleteById(int id);
}
