package yan.ibbie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yan.ibbie.exception.AgeException;
import yan.ibbie.exception.DefaultException;
import yan.ibbie.exception.MyException;
import yan.ibbie.exception.NameException;

@Controller
public class UserController {

    @RequestMapping("/some.do")
    public ModelAndView doSome(String name,int age) throws MyException {

        if(name.startsWith("666")){
            throw new NameException();
        }
        if(age>100){
            throw new AgeException();
        }
        if(age==0){
            throw new DefaultException();
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }
}
