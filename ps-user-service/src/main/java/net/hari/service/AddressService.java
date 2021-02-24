package net.hari.service;

import net.hari.model.AddressDO;
import net.hari.request.AddressAddRequest;
import net.hari.vo.AddressVO;

import java.util.List;

/**
 * @Auther: Hari
 * @Date: 2021/2/2 15:04
 * @Description:
 */
public interface AddressService {

    /**
     * 查找指定地址详情
     * @param id
     * @return
     */
    AddressVO detail(Long id);

    /**
     * 新增收货地址
     * @param addressAddRequest
     */
    void add(AddressAddRequest addressAddRequest);

    /**
     * 根据id删除地址
     * @param addressId
     * @return
     */
    int del(int addressId);

    /**
     * 查找用户全部收货地址
     * @return
     */
    List<AddressVO> listUserAllAddress();
}
