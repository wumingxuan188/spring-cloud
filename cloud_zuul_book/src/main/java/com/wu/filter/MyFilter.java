package com.wu.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.hibernate.validator.internal.util.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * 自定义过滤器
 */
@Component
public class MyFilter extends ZuulFilter {
    static Logger logger=LoggerFactory.getLogger(MyFilter.class);
    /**
     * 过滤器类型
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行的级别
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否要执行过滤
     * true :走run方法
     * false:不走run方法
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 执行的逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if(token==null){
            logger.info("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  null;
        }
        logger.info("ok");
        return "ok1";
    }
}
