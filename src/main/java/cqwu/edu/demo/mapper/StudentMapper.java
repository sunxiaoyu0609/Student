package cqwu.edu.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cqwu.edu.demo.pojo.Students;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper extends BaseMapper<Students> {

//    @Select("select * from students")
//    List<Students> findAll();
//    @Select("select * from students where sno=#{sno}")
//    Students findStudentBySno(String sno);
//    @Insert("insert into students values(#{sno},#{sname},#{ssex},#{spassword})")
//    void addStudent(Students students);
//    @Update("update students set ssex=#{ssex} where sno=#{sno}")
//    void updatestudent(Students students);
//    @Delete("delete from students where sno=#{sno}")
//    void deletestudent(String sno);
}
