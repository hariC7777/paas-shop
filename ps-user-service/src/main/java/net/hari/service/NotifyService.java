package net.hari.service;

import net.hari.enums.SendCodeEnum;
import net.hari.util.JsonData;

/**
 * @Auther: Hari
 * @Date: 2021/2/22 15:25
 * @Description:
 */
public interface NotifyService {
    JsonData sendCode(SendCodeEnum sendCodeEnum, String to );
}
