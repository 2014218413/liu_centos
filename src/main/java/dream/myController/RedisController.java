package dream.myController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 忌冷忌热的怕热不怕冷的吃不胖少年
 * 回首向来萧瑟处，也无风雨也无晴。
 **/
@Controller
public class RedisController {
    @Autowired
    RedisTemplate redisTemplate;
    @RequestMapping("/redis")
    @ResponseBody
    public String op () {
        redisTemplate.opsForValue().set("name","liushengen");
        return "加入redis-----";
    }
}
