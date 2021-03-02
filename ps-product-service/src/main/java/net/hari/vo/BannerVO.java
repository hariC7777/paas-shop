package net.hari.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: Hari
 * @Date: 2021/3/2 15:59
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BannerVO {

    private Integer id;

    /**
     * 图片
     */
    private String img;

    /**
     * 跳转地址
     */
    private String url;

    /**
     * 权重
     */
    private Integer weight;

}
