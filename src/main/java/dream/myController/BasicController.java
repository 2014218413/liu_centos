package dream.myController;


import dream.myService.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 忌冷忌热的怕热不怕冷的吃不胖少年
 * 回首向来萧瑟处，也无风雨也无晴。
 **/
@Controller
public class BasicController {
    @Autowired
    UserServiceImpl userService;

    //登录验证
    @RequestMapping("/login")
    @ResponseBody
    public String login (String username,String password,HttpSession httpSession,HttpServletResponse httpServletResponse) throws IOException {
        if (userService.loginUser(username,password) > 0) {
            httpSession.setAttribute("username",username);
            httpSession.setAttribute("password",password);
            return "/success.html";
        }
        else {
            return "/";
        }
    }

}
