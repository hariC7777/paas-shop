package net.hari.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @Auther: Hari
 * @Date: 2021/2/23 14:17
 * @Description:
 */
@Data
@Builder
public class LoginUser {

    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 头像
     */
    @JsonProperty("head_img")
    private String headImg;

    /**
     * 邮箱
     */
    private String mail;
}
