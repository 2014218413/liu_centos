package dream.sendMail;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author 忌冷忌热的怕热不怕冷的吃不胖少年
 * 回首向来萧瑟处，也无风雨也无晴。
 **/
@Service
public class Q_mail {
    public static String q_mailSend (String code) throws GeneralSecurityException, MessagingException {

        // qq存在一个特性，设置ssl加密
        MailSSLSocketFactory mailSSLSocketFactory = new MailSSLSocketFactory();
        mailSSLSocketFactory.setTrustAllHosts(true);

        Properties properties = new Properties();
        properties.setProperty("mail.host","smtp.qq.com"); //设置QQ邮件服务器
        properties.setProperty("mail.transport.protocol","smtp"); //邮件发送协议
        properties.setProperty("mail.smtp.auth","true"); //需要验证用户名密码
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.ssl.socketFactory",mailSSLSocketFactory);

        //创建一个Session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("2014218413@qq.com","phyzktajdmhdcajg");
            }
        });
        //开启debug模式
//        session.setDebug(true);

        //获取连接对象
        Transport transport = session.getTransport();

        //连接服务器
        transport.connect("smtp.qq.com","2014218413@qq.com","phyzktajdmhdcajg");

        //创建邮件
        MimeMessage mimeMessage = new MimeMessage(session);

        //发送人
        mimeMessage.setFrom(new InternetAddress("2014218413@qq.com"));

        //接收人
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("2014218413@qq.com"));

        //邮件主题
        mimeMessage.setSubject("开拓者联盟");

        // 邮件内容
        mimeMessage.setContent("<h1>永不妥协，永怀激情</h1><br/><div><p>此验证码将作为您的密码暂时使用，请妥善保管</p><br/><span>"+code+"</span></div>","text/html;charset=UTF-8");

        //发送邮件
        try {
            transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        }
        catch (Exception e) {
            return "error";
        }


        //关闭
        transport.close();
        return "success";
    }
}
