package org.sid.securityservice;

import org.sid.securityservice.security.entities.AppRole;
import org.sid.securityservice.security.entities.AppUser;
import org.sid.securityservice.security.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecurityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityServiceApplication.class, args);

    }
    @Bean
    PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
    };
    @Bean
    CommandLineRunner start(AccountService accountService){

       return args -> {
    accountService.addNewRole(new AppRole(null,"USER"));
    accountService.addNewRole(new AppRole(null,"ADMIN"));
    accountService.addNewRole(new AppRole(null,"CUSTOMER_MANAGER"));
    accountService.addNewRole(new AppRole(null,"PRODUCT_MANAGER"));
    accountService.addNewRole(new AppRole(null,"BILLS_MANAGER"));

    accountService.addNewUser(new AppUser(null,"oubada1","1234",new ArrayList<>()));
    accountService.addNewUser(new AppUser(null,"hamza2","1234",new ArrayList<>()));
    accountService.addNewUser(new AppUser(null,"yassin3","1234",new ArrayList<>()));
    accountService.addNewUser(new AppUser(null,"saad4","1234",new ArrayList<>()));
    accountService.addNewUser(new AppUser(null,"admin","0000",new ArrayList<>()));

    accountService.addRoleToUser("oubada1","USER");
    accountService.addRoleToUser("hamza2","USER");
    accountService.addRoleToUser("admin","USER");
    accountService.addRoleToUser("admin","ADMIN");
    accountService.addRoleToUser("hamza2","USER");
    accountService.addRoleToUser("hamza2","CUSTOMER_MANAGER");
    accountService.addRoleToUser("yassin3","USER");
    accountService.addRoleToUser("yassin3","PRODUCT_MANAGER");
    accountService.addRoleToUser("saad4","USER");
    accountService.addRoleToUser("saad4","BILLS_MANAGER");
       };
    }
}
