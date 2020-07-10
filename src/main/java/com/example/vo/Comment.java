package com.example.vo;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NamedQuery(name="Comment.findByBlogid", query="select c from Comment c WHERE c.blogid = ?1")
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentid;

    @ManyToOne
    @JoinColumn(name="EMAIL")
    private User user;
    private String userid;
    private String username;
    private String content;

    @CreationTimestamp
    private Date createdat;

    @ManyToOne
    @JoinColumn(name="WRITEID")
    private Blog blog;

    private Long blogid;


}
