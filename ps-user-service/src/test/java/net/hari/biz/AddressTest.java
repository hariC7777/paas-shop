package net.hari.biz;

import lombok.extern.slf4j.Slf4j;
import net.hari.UserApplication;
import net.hari.model.AddressDO;
import net.hari.service.AddressService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Hari
 * @Date: 2021/2/2 15:40
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
@Slf4j
public class AddressTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void testAddressDetail(){
        AddressDO addressDO = addressService.detail(1L);
        log.info(addressDO.toString());
        Assert.assertNotNull(addressDO);
    }

}
