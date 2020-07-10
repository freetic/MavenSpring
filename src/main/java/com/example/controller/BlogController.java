package com.example.controller;

import com.example.dao.BlogRepository;
import com.example.dao.UserRepository;
import com.example.vo.Blog;
import com.example.vo.User;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/blog")
@CrossOrigin(origins = "*")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;

    //   블로그 작성
    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Map blogInsert(@RequestBody Blog blog) {
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

    @RequestMapping(value = "/detail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Map blogDetail(@RequestBody Blog blog1) {
        Map<String, Object> map = new HashMap<>();
        User user = userRepository.findByEmail(blog1.getUserid());
        Blog blog = blogRepository.findByWriteid(blog1.getWriteid());
        map.put("content", blog.getContent());
        map.put("username", user.getName());
        map.put("createdat", blog.getCreatedat());
        map.put("blogname", blog.getBlogname());
        map.put("userid", user.getEmail());
        map.put("success", true);
        System.out.println(blog);
        return map;
    }

    @PostMapping(value = "/upload")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile multipartFile) {
        File targetFile = new File("src/main/resources/menuimgs/" + multipartFile.getOriginalFilename());
        Map<String, Object> m = new HashMap<>();
        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);
        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);
            e.printStackTrace();
        } finally {
            m.put("success", "success");
            m.put("url", "menuimgs/" + multipartFile.getOriginalFilename());
            System.out.println(multipartFile.getOriginalFilename());
            m.put("fileName", multipartFile.getOriginalFilename());
        }
        return m;
    }

    @GetMapping(value = "/list/{userid}")
    @ResponseStatus(value = HttpStatus.OK)
    public Map getBlogList(@PathVariable("userid") String userid) {
        Map<String, Object> map = new HashMap<>();
        User user = userRepository.findByEmail(userid);
        System.out.println(user);
        Collection<Blog> Blogs = blogRepository.findByUserId(userid);
        System.out.println(Blogs.size());
        map.put("blogs", Blogs);
        map.put("blogname", user.getBlogName());
        return map;
    }

}
