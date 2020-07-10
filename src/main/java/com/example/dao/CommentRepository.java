package com.example.dao;

import com.example.vo.Blog;
import com.example.vo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    <Comment> Collection<Comment> findByBlogid(Long blogid);
}
