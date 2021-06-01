package com.test.webtechproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="COMMENT")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name="COMMENT_ID", unique=true)
    private long commentID;
    private String authorID;
    private LocalDateTime timeStamp;
    private String text;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User userID;

    //private long userID;

    public Comment(String authorID, LocalDateTime timeStamp, String text, User userID) {
        super();
        this.authorID = authorID;
        this.setTimeStamp(LocalDateTime.now());
        this.text = text;
        this.userID = userID;
    }
    public Comment() {

    }

    // Getters & Setters

    public long getId() { return commentID; }

    public void setId(Integer commentID) { this.commentID = commentID; }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

}
