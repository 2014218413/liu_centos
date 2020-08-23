package dream.sendMail.mailCodeProvider;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author 忌冷忌热的怕热不怕冷的吃不胖少年
 * 回首向来萧瑟处，也无风雨也无晴。
 **/

/*
* 随机产生验证码
* */
@Service
public class MailCodeProvider {

    public StringBuilder codeProvide (){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        char [] code = {'A','B','C','1','2','4','5','6','7','8','9','P'};
        for (int i = 0;i<4;i++) {
            char op = code[random.nextInt(code.length-1)];
            stringBuilder.append(op);
        }
        return stringBuilder;
    }
}
