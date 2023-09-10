package com.example.individual.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import java.util.Date;

/**
 * Represents a Chat entity for storing chat-related information.
 *
 * This class is an entity mapped to the "chats" table in the database.
 */
@Entity
@Table(name = "chats")
public class Chat {

    /**
     * The unique identifier for a chat.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * The username of the first chat participant.
     */
    @Column(name = "username1", nullable = false)
    private String username1;

    /**
     * The username of the second chat participant.
     */
    @Column(name = "username2", nullable = false)
    private String username2;

    /**
     * The username of the sender of the last message.
     */
    @Column(name = "sender_username", nullable = false)
    private String senderUsername;

    /**
     * A string representing the last message between the chat participants.
     */
    @Column(name = "last_message_between", nullable = false)
    private String lastMessageBetween;

    /**
     * The date and time when the chat was last viewed.
     */
    @Column(name = "lastly_viewed", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastlyViewed;

    /**
     * The date and time when the last message was sent in the chat.
     */
    @Column(name = "last_message_send_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastMessageSendTime;

    /**
     * Default constructor for the Chat class.
     */
    public Chat() {
        // Default constructor
    }

    /**
     * Parameterized constructor for the Chat class.
     *
     * @param senderUsername     The username of the message sender.
     * @param username1          The username of the first chat participant.
     * @param username2          The username of the second chat participant.
     * @param lastMessageBetween A string representing the last message between participants.
     * @param lastlyViewed       The date and time when the chat was last viewed.
     * @param lastMessageSendTime The date and time when the last message was sent in the chat.
     */
    public Chat(String senderUsername, String username1, String username2, String lastMessageBetween, Date lastlyViewed, Date lastMessageSendTime) {
        this.username1 = username1;
        this.username2 = username2;
        this.lastMessageBetween = lastMessageBetween;
        this.lastlyViewed = lastlyViewed;
        this.lastMessageSendTime = lastMessageSendTime;
        this.senderUsername = senderUsername;
    }

    // Getter and setter methods with documentation comments...
    /**
     * Gets the unique identifier for the chat.
     *
     * @return The chat's unique identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the chat.
     *
     * @param id The chat's unique identifier.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the username of the first chat participant.
     *
     * @return The username of the first participant.
     */
    public String getUsername1() {
        return username1;
    }

    /**
     * Sets the username of the first chat participant.
     *
     * @param username1 The username of the first participant.
     */
    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    /**
     * Gets the username of the second chat participant.
     *
     * @return The username of the second participant.
     */
    public String getUsername2() {
        return username2;
    }

    /**
     * Sets the username of the second chat participant.
     *
     * @param username2 The username of the second participant.
     */
    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    /**
     * Gets the username of the sender of the last message.
     *
     * @return The sender's username.
     */
    public String getSenderUsername() {
        return senderUsername;
    }

    /**
     * Sets the username of the sender of the last message.
     *
     * @param senderUsername The sender's username.
     */
    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    /**
     * Gets the string representing the last message between chat participants.
     *
     * @return The last message between participants.
     */
    public String getLastMessageBetween() {
        return lastMessageBetween;
    }

    /**
     * Sets the string representing the last message between chat participants.
     *
     * @param lastMessageBetween The last message between participants.
     */
    public void setLastMessageBetween(String lastMessageBetween) {
        this.lastMessageBetween = lastMessageBetween;
    }

    /**
     * Gets the date and time when the chat was last viewed.
     *
     * @return The last viewed date and time.
     */
    public Date getLastlyViewed() {
        return lastlyViewed;
    }

    /**
     * Sets the date and time when the chat was last viewed.
     *
     * @param lastlyViewed The last viewed date and time.
     */
    public void setLastlyViewed(Date lastlyViewed) {
        this.lastlyViewed = lastlyViewed;
    }

    /**
     * Gets the date and time when the last message was sent in the chat.
     *
     * @return The date and time of the last message sent.
     */
    public Date getLastMessageSendTime() {
        return lastMessageSendTime;
    }

    /**
     * Sets the date and time when the last message was sent in the chat.
     *
     * @param lastMessageSendTime The date and time of the last message sent.
     */
    public void setLastMessageSendTime(Date lastMessageSendTime) {
        this.lastMessageSendTime = lastMessageSendTime;
    }
}

