package dream.redis.redisServicesImpl;

import dream.redis.redisServices.RedisServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 忌冷忌热的怕热不怕冷的吃不胖少年
 * 回首向来萧瑟处，也无风雨也无晴。
 **/
@Service
public class RedisServicesImpl implements RedisServices {
    @Autowired
    RedisTemplate redisTemplate;

    // 检查email是否之前注册过
    public String checkRedis(String email) {
        String message = (String) redisTemplate.opsForValue().get(email);
        if (message != null) {
            return "yes";
        }
        else {
            return "no";
        }
    }

    // 近期没有接过验证码的记录到 redis 中
    public void addRedis(String email,String code) {
        redisTemplate.opsForValue().set(email,code,60*60*24, TimeUnit.SECONDS);
    }
}
