package com.myspring.boot;

import org.elasticsearch.client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;

/**
 * Hello world!
 * @author hitopei
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"com.myspring.boot.service"})
public class DataApplication {
    public static void main( String[] args ) {
        SpringApplication.run(DataApplication.class);
    }


}
