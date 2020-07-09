package com.example.dao;

import com.example.vo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.Map;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    <Blog> Collection<Blog> findByUserId(String userid);
}
