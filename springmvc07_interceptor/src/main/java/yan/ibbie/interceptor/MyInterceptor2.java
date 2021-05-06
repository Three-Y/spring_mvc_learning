package yan.ibbie.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
配置多个拦截器时
    配置顺序是  拦截器1==>拦截器2
    执行顺序是  [1===>2===]==>controller==>[2====>1===]==>jsp==>[2============>1]
               [preHandle]==>controller==>[postHandle]==>jsp==>[afterCompletion]
    例子：
        111------preHandle()------
        222------preHandle()------
        ------执行控制器方法------
        222------postHandle()------
        111------postHandle()------
        ------show.jsp------
        222------afterCompletion()------
        111------afterCompletion()------
 */
public class MyInterceptor2 implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("222------preHandle()------");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("222------postHandle()------");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("222------afterCompletion()------");
    }
}
