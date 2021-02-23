package net.hari.service.impl;

import net.hari.component.MailService;
import net.hari.enums.BizCodeEnum;
import net.hari.enums.SendCodeEnum;
import net.hari.service.NotifyService;
import net.hari.util.CheckUtil;
import net.hari.util.CommonUtil;
import net.hari.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Hari
 * @Date: 2021/2/22 15:27
 * @Description:
 */
@Service
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    private MailService mailService;

    /**
     * 验证码的标题
     */
    private static final String SUBJECT= "小滴课堂验证码";

    /**
     * 验证码的内容
     */
    private static final String CONTENT= "您的验证码是%s,有效时间是60秒,打死也不要告诉任何人";


    @Override
    public JsonData sendCode(SendCodeEnum sendCodeEnum, String to) {

        if(CheckUtil.isEmail(to)){
            //邮箱验证码
            String code = CommonUtil.getRandomCode(6);
            mailService.sendMail(to,SUBJECT,String.format(CONTENT,code));
            return JsonData.buildSuccess();

        } else if(CheckUtil.isPhone(to)){
            //短信验证码

        }

        return JsonData.buildResult(BizCodeEnum.CODE_TO_ERROR);
    }
}
