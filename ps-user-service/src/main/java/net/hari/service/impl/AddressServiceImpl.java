package net.hari.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import net.hari.enums.AddressStatusEnum;
import net.hari.interceptor.LoginInterceptor;
import net.hari.mapper.AddressMapper;
import net.hari.model.AddressDO;
import net.hari.model.LoginUser;
import net.hari.request.AddressAddRequest;
import net.hari.service.AddressService;
import net.hari.vo.AddressVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Hari
 * @Date: 2021/2/2 15:04
 * @Description:
 */

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;


    @Override
    public AddressVO detail(Long id) {
        LoginUser loginUser = LoginInterceptor.threadLocal.get();
        AddressDO addressDO = addressMapper.selectOne(new QueryWrapper<AddressDO>().eq("id",id).eq("user_id",loginUser.getId()));
        if(addressDO == null){
            return null;
        }
        AddressVO addressVO = new AddressVO();
        BeanUtils.copyProperties(addressDO,addressVO);
        return addressVO;
    }


    /**
     * 新增收货地址
     *
     * @param addressAddRequest
     */
    @Override
    public void add(AddressAddRequest addressAddRequest) {

        LoginUser loginUser = LoginInterceptor.threadLocal.get();
        AddressDO addressDO = new AddressDO();
        addressDO.setCreateTime(new Date());
        addressDO.setUserId(loginUser.getId());

        BeanUtils.copyProperties(addressAddRequest,addressDO);


        //是否有默认收货地址
        if(addressDO.getDefaultStatus() == AddressStatusEnum.DEFAULT_STATUS.getStatus()){
            //查找数据库是否有默认地址
            AddressDO defaultAddressDO = addressMapper.selectOne(new QueryWrapper<AddressDO>()
                    .eq("user_id",loginUser.getId())
                    .eq("default_status",AddressStatusEnum.DEFAULT_STATUS.getStatus()));

            if(defaultAddressDO != null){
                //修改为非默认收货地址
                defaultAddressDO.setDefaultStatus(AddressStatusEnum.COMMON_STATUS.getStatus());
                addressMapper.update(defaultAddressDO,new QueryWrapper<AddressDO>().eq("id",defaultAddressDO.getId()));
            }
        }

        int rows = addressMapper.insert(addressDO);

        log.info("新增收货地址:rows={},data={}",rows,addressDO);

    }

    /**
     * 根据id删除地址
     * @param addressId
     * @return
     */
    @Override
    public int del(int addressId) {
        LoginUser loginUser = LoginInterceptor.threadLocal.get();
        int rows = addressMapper.delete(new QueryWrapper<AddressDO>().eq("id",addressId).eq("user_id",loginUser.getId()));
        return rows;
    }




    /**
     * 查找用全部收货地址
     * @return
     */
    @Override
    public List<AddressVO> listUserAllAddress() {

        LoginUser loginUser = LoginInterceptor.threadLocal.get();
        List<AddressDO> list = addressMapper.selectList(new QueryWrapper<AddressDO>().eq("user_id",loginUser.getId()));

        List<AddressVO> addressVOList =  list.stream().map(obj->{
            AddressVO addressVO = new AddressVO();
            BeanUtils.copyProperties(obj,addressVO);
            return addressVO;
        }).collect(Collectors.toList());

        return addressVOList;

    }

}
