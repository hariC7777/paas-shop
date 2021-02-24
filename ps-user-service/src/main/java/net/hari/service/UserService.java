package net.hari.service;

import net.hari.request.UserLoginRequest;
import net.hari.request.UserRegisterRequest;
import net.hari.util.JsonData;

/**
 * @Auther: Hari
 * @Date: 2021/2/23 11:16
 * @Description:
 */
public interface UserService {
    /**
     * 用户注册
     * @param registerRequest
     * @return
     */
    JsonData register(UserRegisterRequest registerRequest);

    /**
     * 用户登录
     * @param userLoginRequest
     * @return
     */
    JsonData login(UserLoginRequest userLoginRequest);
}
