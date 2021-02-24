package net.hari;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: Hari
 * @Date: 2021/2/24 13:36
 * @Description:
 */

@SpringBootApplication
@MapperScan("net.hari.mapper")
public class CouponApplication {

    public static void main(String [] args){
        SpringApplication.run(CouponApplication.class,args);
    }

}