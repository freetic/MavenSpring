package com.example.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@Data
@NamedQuery(name="User.findByEmail", query="select u from User u where u.email = ?1")
public class User {
    private String name;

    @Id
    private String email;
    private String password;
    private String zipCode;
    private String baseAddress;
    private String detailAddress;
    private String phone;
    private String blogName;
}
