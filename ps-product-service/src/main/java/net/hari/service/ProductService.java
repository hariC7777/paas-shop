package net.hari.service;

import net.hari.vo.ProductVO;

import java.util.Map;

/**
 * @Auther: Hari
 * @Date: 2021/3/2 16:01
 * @Description:
 */
public interface ProductService {

    /**
     * 分页查询商品列表
     * @param page
     * @param size
     * @return
     */
    Map<String,Object> page(int page, int size);

    /**
     * 根据id找商品详情
     * @param productId
     * @return
     */
    ProductVO findDetailById(long productId);

}
