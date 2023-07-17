//package com.produto.produto;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Component
//public class SeedData implements CommandLineRunner {
//
//    @Autowired
//    private AccountService accountService;
//
//    @Autowired
//    private AuthorityRepository authorityRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//            Authority user = new Authority();
//            user.setName("ROLE_USER");
//            authorityRepository.save(user);
//
//            Authority admin = new Authority();
//            admin.setName("ROLE_ADMIN");
//            authorityRepository.save(admin);
//
//            Account account2 = new Account();
//
//
//            account2.setFirstName("Rhuan");
//            account2.setLastName("Guilherme");
//            account2.setEmail("rhuanx18");
//            account2.setPassword("123");
//
//            Set<Authority> authorities2 = new HashSet<>();
//            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);
//            authorityRepository.findById("ROLE_USER").ifPresent(authorities2::add);
//            account2.setAuthorities(authorities2);
//
////            accountService.save(account1);
//            accountService.save(account2);
//
//        }
//    }
