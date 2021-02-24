package net.hari.service;

import net.hari.enums.CouponCategoryEnum;
import net.hari.util.JsonData;

import java.util.Map;

/**
 * @Auther: Hari
 * @Date: 2021/2/24 13:33
 * @Description:
 */
public interface CouponService {

    /**
     * 分页查询优惠券
     * @param page
     * @param size
     * @return
     */
    Map<String,Object> pageCouponActivity(int page, int size);

    /**
     * 领取优惠券接口
     * @param couponId
     * @param category
     * @return
     */
    JsonData addCoupon(long couponId, CouponCategoryEnum category);

}
