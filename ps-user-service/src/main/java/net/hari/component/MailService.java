package net.hari.component;

/**
 * @Auther: Hari
 * @Date: 2021/2/22 15:39
 * @Description:
 */
public interface MailService {

    /**
     * 发送邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendMail(String to,String subject, String content);
}
