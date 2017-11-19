package cn.wudashan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @author wuzhaofeng
 */
@EnableAutoConfiguration
public class SpringBootApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootApplication.class, args);
    }

}
