package cqwu.edu.demo.Config;

import cqwu.edu.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * 启用spring安全框架
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //注入自己的实现类
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private MyAuthenticationHandler authenticationHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/toLogin").permitAll()
                .antMatchers("/level1/**").hasAuthority("vip1")
                .antMatchers("/level2/**").hasAuthority("vip2")
                .antMatchers("/level3/**").hasAuthority("vip3");



        //没有权限，默认到登录页面
        http.formLogin()//自定义编写登录页面
                .loginPage("/login")//登录页面设置
                .loginProcessingUrl("/doLogin")//登录访问路径
                .defaultSuccessUrl("/StudentList.html")//登陆成功后的路径
                .usernameParameter("name")
                .passwordParameter("password");
        //防止网站攻击
        http.csrf().disable();//登出可能存在失败的原因
        //开启记住我功能
        http.rememberMe().rememberMeParameter("remember");
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
