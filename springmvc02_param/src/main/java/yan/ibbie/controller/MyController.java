package yan.ibbie.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import yan.ibbie.pojo.User;

@Controller
public class MyController {

    /*
    一个个接受请求的参数
        在处理器（控制器）的参数列表中加上需要接收的参数列表
        控制器的参数名与客户端的参数名要一致
        当客户端发送请求过来时，spring会从request中获取每个参数
        当调用控制器方法时，会将参数按照参数名赋给形参
        spring框架提供类型转换，能把string转换为int,long,float,double等类型
    假如客户端输入的参数不正确
        HTTP Status 400 – Bad Request
        而且也不会调用控制器方法
    如果控制器接收的参数是包装类型
        客户端没有传递该参数，能执行控制器方法，但是对应的参数值为null
        假如传递的参数不为空也不能转换为对应的包装类，不会执行控制器方法，HTTP Status 400 – Bad Request
    当参数是中文
        如果使用的是get请求，没有乱码问题
        如果使用的是port请求，会有乱码问题（需要使用过滤器处理乱码问题）
     */
    @RequestMapping("/getReqParam.do")
    public ModelAndView doParam(String name, int age){
        System.out.println("name="+name+"   age="+age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }

    /*
    请求参数名与控制器参数名不一致，可以使用注解@RequestParam告诉程序哪个参数对应哪个
    使用@RequestParam后，请求传递过来的参数不能为空，否则HTTP Status 400 – Bad Request
    因为@RequestParam有个required参数，默认值是false，表示参数不能为空，设为true后可以为空
     */
    @RequestMapping("/getReqParam2.do")
    public ModelAndView doParam2(@RequestParam(value = "myname",required = true) String name,
                                 @RequestParam(value = "myage") Integer age){
        System.out.println("doParam2: name="+name+"   age="+age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }

    /*
    控制器使用一个对象接收请求参数，请求参数的参数名与对象的属性名需要一致
    @RequestParam不适应于对象参数
    假如请求参数不完整，可能会报错HTTP Status 400 – Bad Request
        如果对象的属性是int,double等类型，会报错
        如果是对象类型，则为null
     */
    @RequestMapping("/user.do")
    public ModelAndView doParam3(User user){
        System.out.println("doParam3: "+user);
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",user.getName());
        mv.addObject("age",user.getAge());
        mv.setViewName("show");
        return mv;
    }
}
