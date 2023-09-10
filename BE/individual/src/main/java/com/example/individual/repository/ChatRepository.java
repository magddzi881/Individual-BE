package com.example.individual.repository;

import com.example.individual.model.Chat;
import com.example.individual.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface for managing Chat entities.
 */
public interface ChatRepository extends JpaRepository<Chat, Integer> {

    /**
     * Retrieves the latest message between two users.
     *
     * @param user1 The username of the first user.
     * @param user2 The username of the second user.
     * @return The latest message between the specified users.
     */
    @Query("SELECT m FROM Message m WHERE " +
            "((m.senderUsername = :user1 AND m.receiverUsername = :user2) OR " +
            "(m.senderUsername = :user2 AND m.receiverUsername = :user1)) AND " +
            "m.sendTime <= CURRENT_TIMESTAMP ORDER BY m.sendTime DESC LIMIT 1")
    Message findLatestMessageBetweenUsers(@Param("user1") String user1, @Param("user2") String user2);

    /**
     * Retrieves a list of chats between two users.
     *
     * @param username1 The username of the first user.
     * @param username2 The username of the second user.
     * @return A list of chats between the specified users.
     */
    @Query("SELECT c FROM Chat c WHERE (c.username1 = :username1 AND c.username2 = :username2) OR (c.username1 = :username2 AND c.username2 = :username1)")
    List<Chat> findChatsBetweenUsers(@Param("username1") String username1, @Param("username2") String username2);

    /**
     * Retrieves a list of chats involving a specific user.
     *
     * @param username The username of the user.
     * @return A list of chats involving the specified user.
     */
    @Query("SELECT c FROM Chat c WHERE c.username1 = ?1 OR c.username2 = ?1")
    List<Chat> findChatsByUser(String username);
}
