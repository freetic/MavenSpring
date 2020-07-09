package com.example.controller;

import com.example.dao.BlogRepository;
import com.example.dao.UserRepository;
import com.example.service.BlogService;
import com.example.vo.Blog;
import com.example.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/blog")
@CrossOrigin(origins = "*")
public class BlogController {
//    @Autowired
//    private BlogService blogService;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;

//   블로그 작성
    @RequestMapping(value="/insert", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public Map blogInsert(@RequestBody Blog blog){
        User user = userRepository.findByEmail(blog.getUserid());
        Map<String, Object> map = new HashMap<>();
        blog.setUser(user);
        blog.setBlogname(user.getBlogName());
        blog.setUsername(user.getName());
        blogRepository.save(blog);
        map.put("success", true);
        System.out.println(blog);
        return map;
    }

    @GetMapping(value="/list/{userid}")
    @ResponseStatus(value=HttpStatus.OK)
    public Map getBlogList(@PathVariable("userid") String userid){
        Map<String, Object> map = new HashMap<>();
        User user = userRepository.findByEmail(userid);
        List<Blog> mapBlogs = new LinkedList<>();
        mapBlogs = blogRepository.findByUserId(userid);
        map.put("blogs", mapBlogs);
        map.put("blogname", user.getBlogName());
        return map;
    }

}
