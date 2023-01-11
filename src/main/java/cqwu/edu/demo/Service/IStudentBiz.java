package cqwu.edu.demo.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cqwu.edu.demo.pojo.Students;

public interface IStudentBiz extends IService<Students> {
    Students login(Students student);
    IPage<Students> getPage(int currentPage, int pageSize);
}
