package com.example.p3750852.conversation;

import java.util.Date;
import java.util.Random;

/**
 * Created by P3750852 on 2017.08.23..
 */

public class Message {

    private String message;
    private Date sendDate;
    private String url;
    private boolean isMine;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public static Message getRandomMessage() {
        Message m = new Message();
        m.setMessage("Teszt üzenet");
        m.setSendDate(new Date());
        m.setMine(new Random().nextBoolean());
        m.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/MarkZuckerberg-crop.jpg/210px-MarkZuckerberg-crop.jpg");
        return m;
            }
}
