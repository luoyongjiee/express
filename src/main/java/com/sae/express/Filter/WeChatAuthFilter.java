package com.sae.express.Filter;

import com.sae.express.util.tool.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger log = LoggerFactory.getLogger(WeChatAuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session=request.getSession();
        HttpServletResponse response=(HttpServletResponse)servletResponse;

        log.info("requestURI-----------------"+request.getRequestURI());
        //TODO 跳过微信授权测试测试使用，正式使用去除，注意：跳过授权测试则请求/wechat 下面的接口便会出错
       /* openId="ozMTNwsdHlVstvAbGAVpX1LCDHbY";
        session.setAttribute("openId",openId);*/


        String requestUri = request.getRequestURI();
        if("/path/express/send".equals(requestUri)||"/path/express/pick_up_order".equals(requestUri)){
            String openId=(String)session.getAttribute("openId");
            if(StringTools.isBlank(openId)){
                response.sendRedirect("/wechat/redirect?sendRedirect="+request.getRequestURI());
            }else{
                filterChain.doFilter(servletRequest,servletResponse);
            }

        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }


       /* if ((openId!=null&&!openId.equals(""))||request.getRequestURI().startsWith("/wechat")||request.getRequestURI().startsWith("/WEB-INF")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {

        }*/
    }

    @Override
    public void destroy() {

    }
}
