package com.discordshopping.service.repository;

import com.discordshopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email = :email and u.password = :password")
    Optional<User> findUserByPasswordAndEmail(@Param("password") String password, @Param("email") String email);

    @Query("select u from User u where u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}
