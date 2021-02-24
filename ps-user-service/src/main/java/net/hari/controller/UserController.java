package net.hari.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.hari.enums.BizCodeEnum;
import net.hari.request.UserLoginRequest;
import net.hari.service.FileService;
import net.hari.service.UserService;
import net.hari.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hariC
 * @since 2021-02-02
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private FileService fileService;

    @Autowired
    private UserService userService;

    /**
     * 上传用户头像
     *
     * 默认文件大小 1M,超过会报错
     *
     * @param file
     * @return
     */
    @ApiOperation("用户头像上传")
    @PostMapping(value = "upload")
    public JsonData uploadHeaderImg(@ApiParam(value = "文件上传",required = true) @RequestPart("file") MultipartFile file){

        String result = fileService.uploadUserImg(file);

        return result != null?JsonData.buildSuccess(result):JsonData.buildResult(BizCodeEnum.FILE_UPLOAD_USER_IMG_FAIL);

    }

    /**
     * 登录
     * @param loginRequest
     * @return
     */
    @PostMapping("login")
    public JsonData register(@RequestBody UserLoginRequest loginRequest){

        JsonData jsonData = userService.login(loginRequest);
        return jsonData;
    }

}

