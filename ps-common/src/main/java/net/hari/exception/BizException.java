package net.hari.exception;

import lombok.Data;
import net.hari.enums.BizCodeEnum;

/**
 * @Auther: Hari
 * @Date: 2021/2/2 15:32
 * @Description:
 */

@Data
public class BizException extends RuntimeException{
    private int code;
    private String msg;

    public BizException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(BizCodeEnum bizCodeEnum){
        super(bizCodeEnum.getMessage());
        this.code = bizCodeEnum.getCode();
        this.msg = bizCodeEnum.getMessage();
    }
}
