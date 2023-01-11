package cqwu.edu.demo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cqwu.edu.demo.Service.IStudentBiz;
import cqwu.edu.demo.mapper.StudentMapper;
import cqwu.edu.demo.pojo.Students;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private IStudentBiz iStudentBiz;
    @Test
    public void select(){
        LambdaQueryWrapper<Students> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.like(Students::getSname , "");

        Page<Students> studentsPage = new Page<>(1 , 2 , false);
        IPage<Students> studentsIPage = studentMapper.selectPage(studentsPage , userLambdaQueryWrapper);
        System.out.println("总页数： "+studentsIPage.getPages());
        System.out.println("总记录数： "+studentsIPage.getTotal());
        studentsIPage.getRecords().forEach(System.out::println);
    }
    @Test
    public void test1(){
        iStudentBiz.removeById(6);
    }
    @Test
    public void test2(){
       iStudentBiz.list();
    }
    @Test
    public void test3(){
        iStudentBiz.getById(1);
    }
    @Test
    public void test4(){
        IPage<Students> iPage=new Page<>(3,5);
        iStudentBiz.page(iPage);
        System.out.println(iPage.getCurrent());
        System.out.println(iPage.getSize());
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getPages());
        System.out.println(iPage.getRecords());
    }
    @Test
    public void test5(){
        Students students=new Students();
        students.setSname("aa");
        students.setAge(22);
        students.setMajor("软件");
        students.setPassword("1234");
        students.setStatus(1);
        iStudentBiz.save(students);
    }
//    @Test
//    void  test(){
//        //查询
////        System.out.println(studentMapper.findAll());
//        System.out.println(studentMapper.findStudentBySno("201958300001"));
//    }
//    @Test
//    void  add(){
//        Students students=new Students();
//        students.setSname("admin2");
//        students.setSno("admin2");
//        students.setSpassword("admin2");
//        studentMapper.addStudent(students);
//    }
//    @Test
//    void  updatestudents(){
//        Students students=new Students();
//        students.setSname("admin2");
//        students.setSno("admin2");
//        students.setSpassword("admin2");
//        students.setSsex("男");
//        studentMapper.updatestudent(students);
//    }
//    @Test
//    void  deletestudents(){
//        studentMapper.deletestudent("admin2");
////    }
//    @Test
//    void testmybatis(){
//        Students students=new Students();
//        students.setSname("admin2");
//        students.setSno("admin2");
//        students.setSpassword("admin3");
//        students.setSsex("男");
////        studentMapper.insert(students);
//        studentMapper.insert(students);
//    }
}
