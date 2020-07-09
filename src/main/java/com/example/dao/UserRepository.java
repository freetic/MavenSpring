package com.example.dao;

import com.example.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    User save(User user);

//    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);
}
