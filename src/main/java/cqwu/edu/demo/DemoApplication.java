package cqwu.edu.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@MapperScan("cqwu.edu.demo.mapper")
@SpringBootApplication
@ServletComponentScan(basePackages = "cqwu.edu.demo.controller")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @RequestMapping("/")
    @ResponseBody
    public  String index(){
        return "hello boot";
    }
}
