package com.examplesecurity.demo.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.examplesecurity.demo.enums.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsersFromPostgresSqlDb()
                .stream()
                .filter(applicationUser -> applicationUser.getUsername().equals(username))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsersFromPostgresSqlDb() {
        List<ApplicationUser> applicationUsers = new ArrayList<>();
        applicationUsers.add(
                new ApplicationUser(
                STUDENT.getGrantedAuthorities(),
                "anna",
                passwordEncoder.encode("password123"))
        );

        applicationUsers.add(
                new ApplicationUser(
                        ADMIN_TRAINEE.getGrantedAuthorities(),
                        "tom",
                        passwordEncoder.encode("password123"))
        );

        applicationUsers.add(
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        "linda",
                        passwordEncoder.encode("password123"))
        );

        return applicationUsers;
    }
}
