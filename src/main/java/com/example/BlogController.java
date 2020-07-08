package com.example;

import com.example.dao.BlogRepository;
import com.example.service.BlogService;
import com.example.vo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
//    @Autowired
//    private BlogService blogService;
    @Autowired
    private BlogRepository blogRepository;

    @RequestMapping(value="/bloginsert", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public String getBlogList(@RequestBody Blog blog){
//        String writeid = blog.getWriteId();
//        String userid = blog.getUserId() ;
//        String content = blog.getContent();
//        String createat = blog.getContent();
//        String blogname = blog.getBlogName();
//        blogService.insert(blog);
        blogRepository.saveAndFlush(blog);
        return blog.toString();
    }

    @RequestMapping(value="/api/test", method= RequestMethod.GET)
    @ResponseStatus(value=HttpStatus.OK)
    public String getApiTest(){
        return "{\"result\":\"ok\"}";
    }

    @RequestMapping(value="/bloglist", method= RequestMethod.GET)
    @ResponseStatus(value=HttpStatus.OK)
    public String getBlogList(){
        return "select";
    }

}
