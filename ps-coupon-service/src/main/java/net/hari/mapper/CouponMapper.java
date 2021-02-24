package net.hari.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.hari.model.CouponDO;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: Hari
 * @Date: 2021/2/24 13:37
 * @Description:
 */
public interface CouponMapper extends BaseMapper<CouponDO> {

    /**
     * 扣减存储
     * @param couponId
     * @return
     */
    int reduceStock(@Param("couponId") long couponId);
}
