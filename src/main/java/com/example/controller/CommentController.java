package com.example.controller;

import com.example.dao.BlogRepository;
import com.example.dao.CommentRepository;
import com.example.dao.UserRepository;
import com.example.vo.Blog;
import com.example.vo.Comment;
import com.example.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/comment")
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/upload", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value= HttpStatus.OK)
    public Map commentInsert(@RequestBody Comment comment){
        User user = userRepository.findByEmail(comment.getUserid());
        Blog blog = blogRepository.findByWriteid(comment.getBlogid());
        Map<String, Object> map = new HashMap<>();
        comment.setUsername(user.getName());
        map.put("username", user.getName());
        map.put("createdat", comment.getCreatedat());
        map.put("success", true);
        return map;
    }

    @RequestMapping(value="/list", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public Map getCommentList(@RequestBody Blog blog){
        Map<String, Object> map = new HashMap<>();
        Long blogid = blog.getWriteid();
        System.out.println(blogid);
        Collection<Comment> comments = commentRepository.findByBlogid(blogid);
        System.out.println(comments);
        map.put("comments", comments);
        return map;
    }
}
