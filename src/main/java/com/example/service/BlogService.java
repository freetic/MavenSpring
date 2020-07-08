package com.example.service;

import com.example.vo.Blog;

import java.util.List;

public interface BlogService {
    Blog insert(Blog blog);
    Blog selectOne(Long writeid);
    List<Blog> selectAll();
    void update(Blog blog);
    void delete(Long writeid);
}
