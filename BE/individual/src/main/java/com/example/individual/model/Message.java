package com.example.individual.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import java.util.Date;

/**
 * Represents a Message entity for storing message-related information.
 *
 * This class is an entity mapped to the "messages" table in the database.
 */
@Entity
@Table(name = "messages")
public class Message {

    /**
     * The unique identifier for a message.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "chat_id", nullable = false)
    private int chatId;

    /**
     * The date and time when the message was sent.
     */
    @Column(name = "send_time", nullable = false, columnDefinition = "datetime(6)")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    /**
     * The text content of the message.
     */
    @Column(name = "text", nullable = false)
    private String text;

    /**
     * The username of the receiver of the message.
     */
    @Column(name = "receiver_username", nullable = false)
    private String receiverUsername;

    /**
     * The username of the sender of the message.
     */
    @Column(name = "sender_username", nullable = false)
    private String senderUsername;

    /**
     * Default constructor for the Message class.
     */
    public Message() {
        // Default constructor
    }

    /**
     * Parameterized constructor for the Message class.
     *
     * @param sendTime        The date and time when the message was sent.
     * @param text            The text content of the message.
     * @param senderUsername  The username of the sender of the message.
     * @param receiverUsername The username of the receiver of the message.
     */
    public Message(Date sendTime, String text, String senderUsername, String receiverUsername) {
        this.sendTime = sendTime;
        this.text = text;
        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
    }

    // Getter and setter methods with documentation comments...
    /**
     * Gets the unique identifier for the message.
     *
     * @return The message's unique identifier.chatId
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the message.
     *
     * @param id The message's unique identifier.
     */
    public void setId(int id) {
        this.id = id;
    }


    public int getChatId() {
        return chatId;
    }
    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    /**
     * Gets the date and time when the message was sent.
     *
     * @return The date and time when the message was sent.
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * Sets the date and time when the message was sent.
     *
     * @param sendTime The date and time when the message was sent.
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * Gets the text content of the message.
     *
     * @return The text content of the message.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text content of the message.
     *
     * @param text The text content of the message.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the username of the sender of the message.
     *
     * @return The sender's username.
     */
    public String getSenderUsername() {
        return senderUsername;
    }

    /**
     * Sets the username of the sender of the message.
     *
     * @param senderUsername The sender's username.
     */
    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    /**
     * Gets the username of the receiver of the message.
     *
     * @return The receiver's username.
     */
    public String getReceiverUsername() {
        return receiverUsername;
    }

    /**
     * Sets the username of the receiver of the message.
     *
     * @param receiverUsername The receiver's username.
     */
    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername = receiverUsername;
    }
}

