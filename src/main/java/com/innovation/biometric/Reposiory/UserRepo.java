package com.innovation.biometric.Reposiory;

import com.innovation.biometric.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
//    Optional<User> findByUserName(String username);

    Optional<User> findByUserName(String userName);
}
