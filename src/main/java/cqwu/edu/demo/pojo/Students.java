package cqwu.edu.demo.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
//@ConfigurationProperties(prefix = "student1")
@Data
@TableName("student1")//表名与类名不一致
public class Students {
    @TableId(type = IdType.AUTO)
    private Integer  sid;
    private String sname;
    private String password;
    private  Integer age;
    private String major;
    private Integer status;
    private String auth;
}
