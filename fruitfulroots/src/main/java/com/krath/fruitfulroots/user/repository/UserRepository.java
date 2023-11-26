package com.krath.fruitfulroots.user.repository;

import com.krath.fruitfulroots.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value="Select u from User u where u.username = :username")
    User findByUsername(@Param("username") String username);

    @Query(value = "Select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);
}
