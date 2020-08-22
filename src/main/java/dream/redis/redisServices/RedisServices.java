package dream.redis.redisServices;

import org.springframework.stereotype.Service;

/**
 * @author 忌冷忌热的怕热不怕冷的吃不胖少年
 * 回首向来萧瑟处，也无风雨也无晴。
 **/
public interface RedisServices {

    // 检查email是否之前注册过
    String checkRedis (String email);

    // 将接受过验证码的账户记录下来
    void addRedis (String email,String code);
}
