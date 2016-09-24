package com.sae.express.Filter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author： Administrator
 * @Date ： 2016/9/22. 20:42
 *
 */
@Order(Ordered.HIGHEST_PRECEDENCE+10)
public class WeChatAuthFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session=request.getSession();
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        String openId=(String)session.getAttribute("openId");
        System.out.println("request.getMethod()"+request.getRequestURI());
        //TODO 跳过微信授权测试测试使用，正式使用去除，注意：跳过授权测试则请求/wechat 下面的接口便会出错
       /* openId="ozMTNwsdHlVstvAbGAVpX1LCDHbY";
        session.setAttribute("openId",openId);*/
        if ((openId!=null&&!openId.equals(""))||request.getRequestURI().startsWith("/wechat")||request.getRequestURI().startsWith("/WEB-INF")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }else {
            response.sendRedirect("/wechat/redirect?sendRedirect="+request.getRequestURI());
        }
    }

    @Override
    public void destroy() {

    }
}
