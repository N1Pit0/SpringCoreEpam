package com.mygym.crm.config;


import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("com.mygym.crm")
@PropertySource("classpath:application.properties")
public class Configs {

}
