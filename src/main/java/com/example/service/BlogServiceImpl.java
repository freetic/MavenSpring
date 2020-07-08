package com.example.service;

import com.example.dao.BlogRepository;
import com.example.vo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Blog insert(Blog blog) {
        try {
            blogRepository.saveAndFlush(blog);
            System.out.println(blog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blog;
    }

    @Override
    public Blog selectOne(Long writeid) {
        return null;
    }

    @Override
    public List<Blog> selectAll() {
        return null;
    }

    @Override
    public void update(Blog blog) {

    }

    @Override
    public void delete(Long writeid) {

    }
}
