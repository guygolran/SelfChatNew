package com.example.guy.selfchat;

import java.sql.Timestamp;

public class Message {
    private String author, msg, timeStamp;

    public Message(String author, String message) {
        this.author = author;
        this.msg = message;
        this.timeStamp = (new Timestamp(System.currentTimeMillis())).toString().substring(0, 16);
    }

    public String getAuthor() {
        return author;
    }

    public String getMsg() {
        return msg;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}