package cqwu.edu.demo.Service.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cqwu.edu.demo.Service.IStudentBiz;
import cqwu.edu.demo.mapper.StudentMapper;
import cqwu.edu.demo.pojo.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IStudentImpl extends ServiceImpl<StudentMapper, Students> implements IStudentBiz {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Students login(Students student) {
        LambdaQueryWrapper<Students> lqw=new LambdaQueryWrapper<>();
        lqw.eq(Students::getSname,student.getSname());
        lqw.eq(Students::getPassword,student.getPassword());
        return studentMapper.selectOne(lqw);
    }

    @Override
    public IPage<Students> getPage(int currentPage, int pageSize) {
        IPage<Students> iPage=new Page<>(currentPage,pageSize);
        studentMapper.selectPage(iPage,null);
        return iPage;
    }
}
