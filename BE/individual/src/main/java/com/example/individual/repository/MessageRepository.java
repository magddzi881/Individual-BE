package com.example.individual.repository;

import com.example.individual.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Message entities.
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    /**
     * Retrieves a list of messages sent by a specific sender.
     *
     * @param senderUsername The username of the sender.
     * @return A list of messages sent by the specified sender.
     */
    List<Message> findBySenderUsername(String senderUsername);

    /**
     * Retrieves a list of messages received by a specific receiver.
     *
     * @param receiverUsername The username of the receiver.
     * @return A list of messages received by the specified receiver.
     */
    List<Message> findByReceiverUsername(String receiverUsername);

    /**
     * Retrieves a list of messages exchanged between two users, ordered by send time.
     *
     * @param username1 The username of the first user.
     * @param username2 The username of the second user.
     * @return A list of messages exchanged between the specified users.
     */
    @Query("SELECT m FROM Message m WHERE (m.senderUsername = ?1 AND m.receiverUsername = ?2) OR (m.senderUsername = ?2 AND m.receiverUsername = ?1) ORDER BY m.sendTime")
    List<Message> findMessagesBetweenUsers(String username1, String username2);
}
