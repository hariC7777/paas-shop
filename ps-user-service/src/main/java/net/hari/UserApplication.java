package net.hari;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: Hari
 * @Date: 2021/2/2 14:55
 * @Description:
 */

@SpringBootApplication
@MapperScan("net.hari.mapper")
public class UserApplication {
    public static void main(String [] args){
        SpringApplication.run(UserApplication.class,args);
    }
}
