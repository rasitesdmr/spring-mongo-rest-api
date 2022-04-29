package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/*
JavaConfig, @EnableMongoRepositories ek açıklamasını kullanır.
Bu açıklama, MongoDB depolarını yapılandırmaya ve etkinleştirmeye yardımcı olur.
Herhangi bir temel paket yapılandırılmamışsa, açıklamalı yapılandırma sınıfının paketini tarar.
Bir fasulye bildirmek için, @Bean notuyla bir yönteme açıklama eklemeniz yeterlidir.
 */
@SpringBootApplication
@EnableMongoRepositories
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
