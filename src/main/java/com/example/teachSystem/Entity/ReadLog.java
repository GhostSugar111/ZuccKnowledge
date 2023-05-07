package com.example.teachSystem.Entity;

import javax.persistence.*;

@Entity
@Table(name = "knowledge_read_logs" ,schema = "zuccknowledge", catalog = "")
public class ReadLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "knowledge_id")
    private Integer knowledgeId;

    @Column(name = "reader")
    private String reader;

    @Column(name = "read_time")
    private String readTime;

    // default constructor
    public ReadLog() {
    }

    // constructor with parameters
    public ReadLog(Integer knowledgeId, String reader, String readTime) {
        this.knowledgeId = knowledgeId;
        this.reader = reader;
        this.readTime = readTime;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Integer knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }
}
