package dream.myDao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 忌冷忌热的怕热不怕冷的吃不胖少年
 * 回首向来萧瑟处，也无风雨也无晴。
 **/
@Mapper
public interface UserDao {
    //用户注册成功，加入到数据库
    /*
    * 这里涉及到一个问题，就是service层调用这里的dao层 企图将数据传入进来
    * 但是这里 参数是不能进行自动进行匹配的 所以要@Param进行指定
    * */
    public void addUser(@Param("username") String username, @Param("password") String password, @Param("state") String state);

    //登录验证
    public int loginUser (@Param("username") String username,@Param("password") String password);
}
