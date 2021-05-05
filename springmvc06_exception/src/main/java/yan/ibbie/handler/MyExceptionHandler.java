package yan.ibbie.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import yan.ibbie.exception.AgeException;
import yan.ibbie.exception.NameException;

/*
@ControllerAdvice 表示该类是一个通知类
该类的作用是全局的异常处理
 */
@ControllerAdvice
public class MyExceptionHandler {

    /*
    @ExceptionHandler 表示该方法用于异常处理
        value指定要处理的异常
        若不指定value，则该方法处理除已被指定的异常以外的其它异常
    记得将当前包配置到包扫描范围中
    要开启注解驱动
     */
    @ExceptionHandler(NameException.class)
    public ModelAndView nameExp(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("nameError");
        return mv;
    }

    @ExceptionHandler(AgeException.class)
    public ModelAndView ageExp(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ageError");
        return mv;
    }

//    /*
//    @ExceptionHandler 若不指定value，则该方法处理除已被指定的异常以外的其它异常
//     */
//    @ExceptionHandler
//    public ModelAndView allExp(){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("defaultError");
//        return mv;
//    }
}
