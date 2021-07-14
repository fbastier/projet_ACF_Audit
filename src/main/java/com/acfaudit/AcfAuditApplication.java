package com.acfaudit;

import com.acfaudit.document.StorageService;
import com.acfaudit.user.ClientRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = ClientRepository.class)
public class AcfAuditApplication{

    public static void main(String[] args) {
        SpringApplication.run(AcfAuditApplication.class, args);

        System.out.println("Coucou");
    }
    
    @Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
