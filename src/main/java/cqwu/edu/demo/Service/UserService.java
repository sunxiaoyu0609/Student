package cqwu.edu.demo.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cqwu.edu.demo.mapper.StudentMapper;
import cqwu.edu.demo.pojo.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")//这里需要指定
public class UserService implements UserDetailsService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        QueryWrapper<Students> wrapper=new QueryWrapper();
        wrapper.eq("sname",name);
        Students students =studentMapper.selectOne(wrapper);

        if (students == null) {
            //数据库中没有，认证失败
            throw new UsernameNotFoundException("没有找到该用户");
        }
        //权限拆分，字符串拆分成数组
        String[] arr = students.getAuth().split(",");
        //这里需要对密码进行加密，也可以使用java自带的MD5加密，通过工具类AuthorityUtils对数组进行转换
        return new User(students.getSname(), new BCryptPasswordEncoder().encode(students.getPassword()), AuthorityUtils.createAuthorityList(arr));
    }
}
