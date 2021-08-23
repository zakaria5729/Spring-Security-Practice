package com.examplesecurity.demo.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.examplesecurity.demo.enums.ApplicationUserRole.*;

@Repository("test")
public class TestApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    public TestApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsersFromMysqlDb()
                .stream()
                .filter(applicationUser -> applicationUser.getUsername().equals(username))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsersFromMysqlDb() {
        List<ApplicationUser> applicationUsers = new ArrayList<>();
        applicationUsers.add(
                new ApplicationUser(
                STUDENT.getGrantedAuthorities(),
                "panna",
                passwordEncoder.encode("password123"))
        );

        applicationUsers.add(
                new ApplicationUser(
                        ADMIN_TRAINEE.getGrantedAuthorities(),
                        "jerry",
                        passwordEncoder.encode("password123"))
        );

        applicationUsers.add(
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        "panda",
                        passwordEncoder.encode("password123"))
        );

        return applicationUsers;
    }
}
