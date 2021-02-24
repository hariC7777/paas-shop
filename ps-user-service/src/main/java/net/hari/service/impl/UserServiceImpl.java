package net.hari.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import net.hari.enums.BizCodeEnum;
import net.hari.enums.SendCodeEnum;
import net.hari.mapper.UserMapper;
import net.hari.model.LoginUser;
import net.hari.model.UserDO;
import net.hari.request.UserLoginRequest;
import net.hari.request.UserRegisterRequest;
import net.hari.service.NotifyService;
import net.hari.service.UserService;
import net.hari.util.CommonUtil;
import net.hari.util.JWTUtil;
import net.hari.util.JsonData;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Hari
 * @Date: 2021/2/23 11:18
 * @Description:
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private NotifyService notifyService;


    @Autowired
    private UserMapper userMapper;


    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    public JsonData register(UserRegisterRequest registerRequest) {
        return null;
    }

    @Override
    public JsonData login(UserLoginRequest loginRequest) {
        List<UserDO> list = userMapper.selectList(
                new QueryWrapper<UserDO>().eq("mail", loginRequest.getMail()));

        if (list != null && list.size() == 1) {
            UserDO userDO = list.get(0);
            String cryptPwd = Md5Crypt.md5Crypt(loginRequest.getPwd().getBytes(), userDO.getSecret());
            if (cryptPwd.equals(userDO.getPwd())) {
                //生成token令牌
                LoginUser userDTO = new LoginUser();
                BeanUtils.copyProperties(userDO, userDTO);
                String token = JWTUtil.geneJsonWebToken(userDTO);
                return JsonData.buildSuccess(token);
            }
            //密码错误
            return JsonData.buildResult(BizCodeEnum.ACCOUNT_PWD_ERROR);
        } else {
            //未注册
            return JsonData.buildResult(BizCodeEnum.ACCOUNT_UNREGISTER);
        }
    }
}
