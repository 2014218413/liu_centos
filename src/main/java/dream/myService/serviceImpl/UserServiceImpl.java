package dream.myService.serviceImpl;

import dream.myDao.dao.UserDao;
import dream.myService.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 忌冷忌热的怕热不怕冷的吃不胖少年
 * 回首向来萧瑟处，也无风雨也无晴。
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    public void addUser(String username,String password,String state) {
        userDao.addUser(username,password,state);
    }

    public int loginUser(String username, String password) {
        return userDao.loginUser(username,password);
    }
}
