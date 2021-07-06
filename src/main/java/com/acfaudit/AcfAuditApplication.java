package com.acfaudit;

import com.acfaudit.user.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = ClientRepository.class)
public class AcfAuditApplication{

    public static void main(String[] args) {
        SpringApplication.run(AcfAuditApplication.class, args);

        System.out.println("Coucou");

    }

}
