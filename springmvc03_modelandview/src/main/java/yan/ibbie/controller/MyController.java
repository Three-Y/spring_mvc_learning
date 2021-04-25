package yan.ibbie.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;
import yan.ibbie.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class MyController {

    /*
    只返回视图
        直接返回视图名字即可
        注意：假如配置了视图解析器，但是使用了完整的视图路径，会报错（可解决）
        使用forward的方式转发到指定的视图
    如果有要返回的参数
        手动添加到HttpServletRequest域中
     */
    @RequestMapping("/some.do")
    public String doRes(String name, int age, HttpServletRequest request){
        System.out.println("执行doRes()");
        request.setAttribute("name",name);
        request.setAttribute("age",age);
        return "show";
    }

    /*
    控制器返回值是void，使用HttpServletResponse返回数据，只返回数据，不返回视图
        返回一个json对象
     */
    @RequestMapping("/some2.do")
    public void doReturnByAjax(String name, int age, HttpServletResponse response){
        System.out.println("==doReturnByAjax()==");
        User user = new User();
        user.setName(name);
        user.setAge(age);

        //将对象转换成json数据
        String json = "";
        if(user!=null){
            ObjectMapper om = new ObjectMapper();
            try {
                json = om.writeValueAsString(user);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        //响应json数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.flush();
        writer.close();
    }

    /*
    返回一个对象
        使用框架将要返回的对象自动转换成json，然后用HttpServletResponse响应ajax请求
        1.添加注解驱动，框架会自动多生成几个HttpMessageConverter的实现类，其中就有MappingJackson2HttpMessageConverter
            关于HttpMessageConverter：
                判断传进去的数据能否转换成指定的格式（如pdf，xml，img等）
                将数据转换成需要的格式
        2.在处理器添加@ResponseBody，表示会将返回的对象转换成json数据并用HttpServletResponse返回
     */
    @ResponseBody
    @RequestMapping("/some3.do")
    public User doUserByJson(String name, int age){
        User user = new User();
        user.setName("我是ibbie");
        user.setAge(22);
        return user;
    }

}
