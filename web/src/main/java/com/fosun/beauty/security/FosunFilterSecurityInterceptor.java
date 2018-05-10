package com.fosun.beauty.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class FosunFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private FilterInvocationSecurityMetadataSource securityMetadataSource;

    @Autowired
    public void setMyAccessDecisionManager(FosunAccessDecisionManager fosunAccessDecisionManager) {
        super.setAccessDecisionManager(fosunAccessDecisionManager);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

         // TODO: 2018/5/10 前端没有做登录，暂时开放  add by junfu.chen
        /*登录功能完成删除*/
        chain.doFilter(request,response);

        /* 以下代码登录完成后放开*/
//        if(!needToFilter(request)){
//            chain.doFilter(request,response);
//        }else{
//            FilterInvocation fi = new FilterInvocation(request, response, chain);
//            invoke(fi);
//        }

    }

    private void invoke(FilterInvocation fi) throws IOException, ServletException {
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }

    private boolean needToFilter(ServletRequest request){
        if(request instanceof HttpServletRequest){
            AntPathRequestMatcher matcher = new AntPathRequestMatcher("/api/**");
           return matcher.matches((HttpServletRequest)request);
        }
        return true;
    }

    @Override
    public void destroy() {
    }

    @Override
    public Class<? extends Object> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }

}
