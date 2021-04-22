package yan.ibbie.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
@RequestMapping("/my")
用于类上，表示/my/*的请求会分发到此处，再根据/my后面的url分到该类的某个方法
此时类中每个方法：
    完整RequestMapping=类配置的RequestMapping+方法的RequestMapping
 */
@Controller //声明为一个控制器（处理器），作用与@Component相同，为该类创建一个bean
public class MyConroller {

    /*
    @RequestMapping
        value：指定该方法要处理的请求，可以用在方法或类上
               建议加上斜杠"/"，斜杠代表项目的根http://localhost:8080/springmvc01/
               value可以配置多个值，表示多种请求都分发到此方法处理
        method：指定请求的方式
                如果使用了错误的请求方式：HTTP Status 405 – Method Not Allowed
                不限制请求方式，则任何请求方式都可以
     */
    //@RequestMapping(value = {"/abc.do","/efg.do"})
    @RequestMapping(value = "/some.do",method = RequestMethod.GET)
    public ModelAndView doSome(){
        //ModelAndView 用于存储本次请求的处理结果
        //  Moder  数据，要传递给用户的数据
        //  View  视图，比如jsp

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","Hello, Spring MVC");
        mv.addObject("hi","Hi, 我是doSome()处理后的结果");

        //配置视图解析器后，视图的路径简化了
        //mv.setViewName("/WEB-INF/views/some.jsp");
        //mv.setViewName("/WEB-INF/views/show.jsp");
        mv.setViewName("some");

        return mv;
    }

    //get请求
    @RequestMapping(value = "/show.do",method = RequestMethod.POST)
    public ModelAndView doShow(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("show");
        return mv;
    }

    //不限制请求方式，则任何请求方式都可以
    @RequestMapping(value = "/other.do")
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("other");
        return mv;
    }

}
