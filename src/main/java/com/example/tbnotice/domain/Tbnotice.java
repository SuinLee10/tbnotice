package com.example.tbnotice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Table
@Entity
public class Tbnotice {
    @Id private String id;
    @Setter @Column(nullable = false) private String title;
    @Setter @Column(nullable = false) private String cate;
    @Setter @Column(nullable = false) private String content;

    protected Tbnotice(){}

    private Tbnotice(String id, String title, String cate, String content){
        this.id = id;
        this.title = title;
        this.cate = cate;
        this.content = content;
    }

    public static Tbnotice of(String title, String cate, String content){
        String id = UUID.randomUUID().toString().replace("-" , "").substring(0, 12);
        return new Tbnotice(id, title, cate, content);
    }
}
