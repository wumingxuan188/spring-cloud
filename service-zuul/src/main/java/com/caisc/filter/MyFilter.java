package com.caisc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义zuul过滤器
 */
@Component
public class MyFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 过滤的类型
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }


    /**
     * 过滤的顺序
     * 越小越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    //是否要过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }

   //业务逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
           //设置不路由
            ctx.setSendZuulResponse(false);
            //ctx.setResponseStatusCode(401);
            try {
              // ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return "token is empty";
        }
        log.info("ok");
        return null;

    }
}
