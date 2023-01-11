package cqwu.edu.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cqwu.edu.demo.Service.IStudentBiz;
import cqwu.edu.demo.controller.utils.R;
import cqwu.edu.demo.pojo.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentBiz iStudentBiz;
    @GetMapping
    public R findAll(){
        return new R(true,iStudentBiz.list());
    }
    @GetMapping("{sid}")
    public R getByid(@PathVariable Integer sid){
        return  new R(true,iStudentBiz.getById(sid));
    }
    @PostMapping
    public R save(@RequestBody Students students){
        return new R(iStudentBiz.save(students));
    }
    @PutMapping
    public R update(@RequestBody Students students){
        return new R(iStudentBiz.updateById(students));
    }
    @DeleteMapping("{sid}")
    public R delete(@PathVariable Integer sid){
        return new R(iStudentBiz.removeById(sid));
    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return new R(true,iStudentBiz.getPage(currentPage,pageSize));
    }
    @PostMapping("/doLogin")
    public String login(){
        return "StudentList";
    }












//    @GetMapping
//    public List<Students> findAll(){
//        return iStudentBiz.list();
//    }
//    @GetMapping("{sid}")
//    public Students getByid(@PathVariable Integer sid){
//        return iStudentBiz.getById(sid);
//    }
//    @PostMapping
//    public Boolean save(Students students){
//        return iStudentBiz.save(students);
//    }
//    @PutMapping
//    public Boolean update(@RequestBody Students students){
//        return iStudentBiz.updateById(students);
//    }
//    @DeleteMapping("{sid}")
//    public Boolean delete(@PathVariable Integer sid){
//        return iStudentBiz.removeById(sid);
//    }
//    @GetMapping("{currentPage}/{pageSize}")
//    public IPage<Students> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//        return iStudentBiz.getPage(currentPage,pageSize);
//    }
}
