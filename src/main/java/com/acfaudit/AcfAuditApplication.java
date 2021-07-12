package com.acfaudit;

import com.acfaudit.document.StorageService;
import com.acfaudit.user.ClientRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;


@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = ClientRepository.class)
public class AcfAuditApplication implements CommandLineRunner {
	
	@Resource
	StorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(AcfAuditApplication.class, args);

        System.out.println("Coucou");
    }
    
    @Override
    public void run(String... arg) throws Exception {
      storageService.init();
    }

}
