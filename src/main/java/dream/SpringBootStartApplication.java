package dream;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author 忌冷忌热的怕热不怕冷的吃不胖少年
 * 回首向来萧瑟处，也无风雨也无晴。
 **/
/*修改启动类，继承SpringBootServletInitializer类并重写configure方法
*
* 这是将 springboot项目部署到外置tomcat上需要设置的
* */
public class SpringBootStartApplication extends SpringBootServletInitializer {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        //注意这里的参数要指向原先用main方法执行的Application启动类
//        return builder.sources(Application_.class);
//    }
}