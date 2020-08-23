package dream.myService.service;

/**
 * @author 忌冷忌热的怕热不怕冷的吃不胖少年
 * 回首向来萧瑟处，也无风雨也无晴。
 **/
public interface UserService {

    //用户注册成功，加入到数据库
    public void addUser(String username,String password,String state);

    // 登录验证
    public int loginUser (String username,String password);
}
