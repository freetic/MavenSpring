package com.example.controller;

import com.example.dao.UserRepository;
import com.example.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Map signup(@RequestBody User user) {
        User person = userRepository.findByEmail(user.getEmail());
        Map<String, Object> map = new HashMap<String, Object>();
        if (person == null) {
            userRepository.save(user);
            map.put("success", true);
        } else {
            map.put("success", false);
        }
//        System.out.println(user);
        return map;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Map login(@RequestBody User user) {
        User person = userRepository.findByEmail(user.getEmail());
        Map<String, Object> map = new HashMap<String, Object>();
//        이메일 있고, 비밀번호가 같으면 성공, 아니면 실패
        if (person != null) {
            String password = person.getPassword();
            if (password.equals(user.getPassword())) {
                map.put("email", user.getEmail());
                map.put("password", user.getPassword());
                map.put("success", true);
            } else {
                map.put("success", false);
            }
        } else {
            map.put("success", false);
        }
        System.out.println(user);
        return map;
    }
}
