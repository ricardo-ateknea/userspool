package com.ateknea.user.userspool.repository;

import com.ateknea.user.userspool.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class interface to deal with the repository of Users.
 */
public interface UserRepository extends JpaRepository<User, Long>{
}
