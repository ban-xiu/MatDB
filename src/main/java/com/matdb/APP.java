package com.matdb;

import com.matdb.config.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(CorsConfig.class)
public class APP {
    public static void main(String[] args) {
        SpringApplication.run(APP.class,args);
    }
}
