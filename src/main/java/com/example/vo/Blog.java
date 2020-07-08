package com.example.vo;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Blog {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="WRITEID")
    private Long writeid;

    @Column(name="USERID")
    private String userid;

    @Column(name="CONTENT")
    private String content;

//    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name="CREATEAT")
    private Date createat;

    @Column(name="BLOGNAME")
    private String blogname;

}
