package com.cme.zuul.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;

@Component
public class PreFilter extends ZuulFilter {

    int count = 0;// 统计当前Zuul调用次数

    @Value("${server.port}")
    private String prot;
    
    /**
     * 指定该过滤类型
     * ERROR_TYPE = "error";  - 异常过滤
     * POST_TYPE = "post";    - 远程服务调用后过滤
     * PRE_TYPE = "pre";      - 前置过滤
     * ROUTE_TYPE = "route";  - 路由后过滤
     */
    @Override
    public String filterType() {
        System.out.println("filterType()...");
        return "pre";
    }

    /**
     * 过滤执行的顺序（自然升序）
     * DEBUG_FILTER_ORDER = 1;
     * FORM_BODY_WRAPPER_FILTER_ORDER = -1;
     * PRE_DECORATION_FILTER_ORDER = 5;
     * RIBBON_ROUTING_FILTER_ORDER = 10;
     * SEND_ERROR_FILTER_ORDER = 0;
     * SEND_FORWARD_FILTER_ORDER = 500;
     * SEND_RESPONSE_FILTER_ORDER = 1000;
     * SIMPLE_HOST_ROUTING_FILTER_ORDER = 100;
     * SERVLET_30_WRAPPER_FILTER_ORDER = -2;
     * SERVLET_DETECTION_FILTER_ORDER = -3;
     */
    @Override
    public int filterOrder() {
        System.out.println("filterOrder()...");
        return 0;
    }

    /**
     * 返回true 则执行run()
     * 返回false 则不执行run()
     */
    @Override
    public boolean shouldFilter() {
        System.out.println("shouldFilter()...");
        return true;
    }

    /**
     * run() 方法就是过滤器的具体逻辑。
     * return 可以返回任意的对象，当前实现忽略。（spring-cloud-zuul官方解释）
     * 直接返回null即可。
     */
    @Override
    public Object run() {
        // 获取上下文
        //RequestContext currentContext = RequestContext.getCurrentContext();
        //HttpServletRequest request = currentContext.getRequest();
        //获取userToken
       // String userToken = request.getParameter("userToken");
        //System.out.println("userToken: "+userToken);
        //if (StringUtils.isEmpty(userToken)) {
            //不会继续执行调用服务接口，网关直接响应给客户端
            //currentContext.setSendZuulResponse(false);
            //currentContext.setResponseStatusCode(401);
           // currentContext.setResponseBody("userToken is Null");
           // return null;
       // }else if(!userToken.equals("10010")){
           // currentContext.setSendZuulResponse(false);
            //currentContext.setResponseStatusCode(401);
            //currentContext.setResponseBody("userToken is Error");
            //return null;
        //}
        // 否则正常执行业务逻辑，调用服务.....
        System.out.println("访问Zuul网关端口为："+prot +"（total："+ ( count++) +"）");
        
        System.out.println("------------pre------前置过滤-----------");
        
        
    
        return null;
    }
    
    
}

