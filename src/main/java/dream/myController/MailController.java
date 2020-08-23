package dream.myController;

import dream.myService.serviceImpl.UserServiceImpl;
import dream.redis.redisServicesImpl.RedisServicesImpl;
import dream.sendMail.Q_mail;
import dream.sendMail.mailCodeProvider.MailCodeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

/**
 * @author 忌冷忌热的怕热不怕冷的吃不胖少年
 * 回首向来萧瑟处，也无风雨也无晴。
 **/
@Controller
public class MailController {

    // 记录到redis
    @Autowired
    RedisServicesImpl redisServices;
    // 插入到mysql数据库
    @Autowired
    UserServiceImpl userService;
    // 验证码生产者
    @Autowired
    MailCodeProvider mailCodeProvider;

    /*
    * 对传入的 email 进行判断，如果redis 中有它的记录说明它近期接过验证码
    * 则不再进行发送新的验证码
    *
    * 如果没有则发送验证码，同时返回的message变量 可以用来判断验证码
    * 是否发送成功，如果成功记录到redis
    * */
    @RequestMapping("/sendMail")
    @ResponseBody
    public String sendMail (String email) throws GeneralSecurityException, MessagingException {
        String flag = redisServices.checkRedis(email);
        if (flag=="yes") {
            return "yes";
        }
        else {
            String code = mailCodeProvider.codeProvide().toString();
            String message = Q_mail.q_mailSend(code,email);
            if (message=="success") {
                redisServices.addRedis(email,code);
                userService.addUser(email,code,"1");

            }
            return message;
        }


    }
}
