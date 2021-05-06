package yan.ibbie.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
拦截器
    实现HandlerInterceptor接口，该接口有三个方法
    要在配置文件注册拦截器
    一般用于请求的验证
 */
public class MyInterceptor implements HandlerInterceptor {

    //控制器执行前执（主要使用该方法）
    //参数：Object handler 被拦截的控制器对象
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("111------preHandle()------");
        return true;//若返回false，拦截请求
    }

    //控制器执行后执行（可对控制器执行结果进行二次修改）
    //参数：Object handler 被拦截的控制器对象
    //     ModelAndView modelAndView 控制器方法的返回值
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("111------postHandle()------");
    }

    //请求完成后执行（一般用于资源回收）
    //参数：Object handler 被拦截的控制器对象
    //     Exception ex 程序中发生的异常
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("111------afterCompletion()------");
    }
}
