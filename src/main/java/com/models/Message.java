package com.models;

import java.sql.Timestamp;

public class Message {
    private int messageId;
    private String senderMessage;
    private String textMessage;
    private Timestamp messageDate;

    public Message(String senderMessage, String textMessage, Timestamp messageDate) {
        this.senderMessage = senderMessage;
        this.textMessage = textMessage;
        this.messageDate = messageDate;
    }

    public int getId() {
        return messageId;
    }

    @Override
    public String toString() {
        return "Message [senderMessage=" + senderMessage + ", textMessage=" + textMessage
                + ", messageDate=" + messageDate + "]";
    }

    public String getSenderMessage() {
        return senderMessage;
    }

    public void setSenderMessage(String senderMessage) {
        this.senderMessage = senderMessage;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public Timestamp getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Timestamp messageDate) {
        this.messageDate = messageDate;
    }

}
