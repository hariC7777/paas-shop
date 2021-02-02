package net.hari.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.hari.mapper.AddressMapper;
import net.hari.model.AddressDO;
import net.hari.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Hari
 * @Date: 2021/2/2 15:04
 * @Description:
 */

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public AddressDO detail(Long id) {
        AddressDO addressDO = addressMapper.selectOne(new QueryWrapper<AddressDO>().eq("id",id));
        return addressDO;
    }
}
