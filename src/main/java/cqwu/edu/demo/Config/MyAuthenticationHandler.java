package cqwu.edu.demo.Config;

import com.fasterxml.jackson.databind.ObjectMapper;

import cqwu.edu.demo.controller.utils.R;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {
    private ObjectMapper objectMapper;
    public MyAuthenticationHandler(){
        objectMapper=new ObjectMapper();
    }
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        R r=new R("用户认证失败");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(r));
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        R r=new R("用户认证成功");
        r.setFlag(true);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(r));
    }
}
