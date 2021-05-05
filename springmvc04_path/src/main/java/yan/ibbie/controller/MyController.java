package yan.ibbie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    //此时没有配置视图解析器
    @RequestMapping("/user/some2.do")
    public ModelAndView doParam2(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index.jsp");
        return mv;
    }

    //此时有配置视图解析器
    @RequestMapping("/some.do")
    public ModelAndView doParam3(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("show");
        return mv;
    }


}
