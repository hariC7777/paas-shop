package net.hari.service;

import net.hari.vo.CouponRecordVO;

import java.util.Map;

/**
 * @Auther: Hari
 * @Date: 2021/3/2 10:02
 * @Description:
 */
public interface CouponRecordService {

    /**
     * 分页查询领劵记录
     * @param page
     * @param size
     * @return
     */
    Map<String,Object> page(int page, int size);

    /**
     * 根据id查询详情
     * @param recordId
     * @return
     */
    CouponRecordVO findById(long recordId);

}
