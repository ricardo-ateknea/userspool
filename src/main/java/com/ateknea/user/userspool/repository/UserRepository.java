package com.ateknea.user.userspool.repository;

import com.ateknea.user.userspool.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Class interface to deal with the repository of Users.
 */
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findById(long id);

    User findByName(String name);
}
