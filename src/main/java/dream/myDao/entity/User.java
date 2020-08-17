package dream.myDao.entity;

import lombok.Data;

/**
 * @author 忌冷忌热的怕热不怕冷的吃不胖少年
 * 回首向来萧瑟处，也无风雨也无晴。
 **/
@Data
public class User {
    private String username;
    private String password;
    private  String state;
    private String email;
}
