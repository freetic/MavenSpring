package com.example.vo;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NamedQuery(name="Blog.findByUserId", query="select b from Blog b WHERE b.userid = ?1")
public class Blog {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long writeid;

    @ManyToOne
    @JoinColumn(name="EMAIL")
    private User user;
    private String userid;
    private String content;

    @CreationTimestamp
    private Date createdat;
    private String username;
    private String blogname;

}
