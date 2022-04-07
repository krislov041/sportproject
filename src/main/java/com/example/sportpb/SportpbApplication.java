package com.example.sportpb;

import com.example.sportpb.entity.Sportevent;
import com.example.sportpb.mapper.SporteventMapper;
import com.example.sportpb.mapper.SporteventMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//@SpringBootApplication()
//取消springboot自动配置数据源
@SpringBootApplication()
//标识
@RestController
//@MapperScan{basePackage=("com.example.sportpb.mapper")}
public class SportpbApplication {


    public static void main(String[] args) {
        SpringApplication.run(SportpbApplication.class, args);
    }


}
