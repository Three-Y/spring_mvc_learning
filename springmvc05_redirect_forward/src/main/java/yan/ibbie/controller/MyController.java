package yan.ibbie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    /*
    使用forward转发到其它页面（客户端只发起了一次请求，请求在服务器的转发过程客户端并不知情）
    可以转发到其它控制器
    使用forward关键字时会无视视图解析器的配置
    语法：forward:视图的完整路径
    使用场景：当需要转发的页面不在视图解析器配置的路径下时，可以使用forward关键字进行转发
     */
    @RequestMapping("/doForward.do")
    public String doForward(){
        return "forward:/WEB-INF/hello.jsp";
    }

    /*
    使用redirect重定向到其它页面（客户端发起了两次请求，A找B帮忙，B让A自己去找C帮忙，A再去找C）
    可以重定向到其它控制器
    使用redirect关键字也会无视视图解析器的配置
    假如重定向时传递了请求参数，框架会将参数转换为string作为get请求的参数
    重定向是客户端重新发送请求，是访问不了/WEB-INF/下的资源的
     */
    @RequestMapping("/doRedirect.do")
    public ModelAndView doRedirect(String name,int age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("redirect:/hello.jsp");
        //http://localhost:8080/springmvc05/hello.jsp?name=ibbie&age=18
        return mv;
    }
}
