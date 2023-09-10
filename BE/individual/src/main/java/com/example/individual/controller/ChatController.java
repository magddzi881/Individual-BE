package com.example.individual.controller;

import com.example.individual.model.Chat;
import com.example.individual.model.Message;
import com.example.individual.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller responsible for handling chat-related operations.
 */
@RestController
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    /**
     * Get a list of all chats.
     *
     * @return A list of Chat objects representing all chats in the system.
     */
    @GetMapping
    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    /**
     * Get a chat by its unique ID.
     *
     * @param id The unique ID of the chat.
     * @return ResponseEntity containing the Chat object if found, or a not-found response.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Chat> getChatById(@PathVariable("id") int id) {
        Optional<Chat> optionalChat = chatRepository.findById(id);
        return optionalChat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Get the latest message between two users.
     *
     * @param user1 The username of the first user.
     * @param user2 The username of the second user.
     * @return ResponseEntity containing the latest Message object if found, or a not-found response.
     */
    @GetMapping("/latestMessage")
    public ResponseEntity<Message> getLatestMessageBetweenUsers(@RequestParam("user1") String user1, @RequestParam("user2") String user2) {
        Message latestMessage = chatRepository.findLatestMessageBetweenUsers(user1, user2);

        if (latestMessage != null) {
            return ResponseEntity.ok(latestMessage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Get chats between two users.
     *
     * @param username1 The username of the first user.
     * @param username2 The username of the second user.
     * @return ResponseEntity containing a list of Chat objects if found, or a not-found response.
     */
    @GetMapping("/betweenUsers")
    public ResponseEntity<List<Chat>> getChatsBetweenUsers(
            @RequestParam("user1") String username1,
            @RequestParam("user2") String username2) {
        List<Chat> chats = chatRepository.findChatsBetweenUsers(username1, username2);

        if (chats.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(chats);
    }

    /**
     * Get chats associated with a specific user.
     *
     * @param username The username of the user.
     * @return ResponseEntity containing a list of Chat objects if found, or a not-found response.
     */
    @GetMapping("/byUser")
    public ResponseEntity<List<Chat>> getChatsByUser(@RequestParam("user") String username) {
        List<Chat> chats = chatRepository.findChatsByUser(username);

        if (chats.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(chats);
    }

    /**
     * Create a new chat.
     *
     * @param chat The Chat object to be created.
     * @return ResponseEntity containing the created Chat object.
     */
    @PostMapping
    public ResponseEntity<Chat> createChat(@RequestBody Chat chat) {
        Chat createdChat = chatRepository.save(chat);
        return ResponseEntity.ok(createdChat);
    }

    /**
     * Update an existing chat by ID.
     *
     * @param id          The unique ID of the chat to be updated.
     * @param updatedChat The updated Chat object.
     * @return ResponseEntity containing the updated Chat object if found, or a not-found response.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Chat> updateChat(@PathVariable("id") int id, @RequestBody Chat updatedChat) {
        Optional<Chat> optionalChat = chatRepository.findById(id);
        if (optionalChat.isPresent()) {
            Chat chat = optionalChat.get();


            if (updatedChat.getUsername1() != null) {
                chat.setUsername1(updatedChat.getUsername1());
            }
            if (updatedChat.getUsername2() != null) {
                chat.setUsername2(updatedChat.getUsername2());
            }
            if (updatedChat.getSenderUsername() != null) {
                chat.setSenderUsername(updatedChat.getSenderUsername());
            }
            if (updatedChat.getLastMessageBetween() != null) {
                chat.setLastMessageBetween(updatedChat.getLastMessageBetween());
            }
            if (updatedChat.getLastMessageSendTime() != null) {
                chat.setLastMessageSendTime(updatedChat.getLastMessageSendTime());
            }
            if (updatedChat.getLastMessageSendTime() != null) {
                chat.setLastlyViewed(updatedChat.getLastlyViewed());
            }

            Chat updated = chatRepository.save(chat);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Partially update an existing chat by ID (e.g., update the last viewed time).
     *
     * @param id          The unique ID of the chat to be updated.
     * @param updatedChat The partial Chat object with updated fields.
     * @return ResponseEntity containing the updated Chat object if found, or a not-found response.
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Chat> patchChat(@PathVariable("id") int id, @RequestBody Chat updatedChat) {
        Optional<Chat> optionalChat = chatRepository.findById(id);
        if (optionalChat.isPresent()) {
            Chat chat = optionalChat.get();
            // Update specific fields of chat using values from updatedChat
            chat.setLastlyViewed(updatedChat.getLastlyViewed());

            Chat updated = chatRepository.save(chat);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a chat by ID.
     *
     * @param id The unique ID of the chat to be deleted.
     * @return ResponseEntity containing a success message if the chat is deleted, or a not-found response.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChat(@PathVariable("id") int id) {
        Optional<Chat> optionalChat = chatRepository.findById(id);
        if (optionalChat.isPresent()) {
            chatRepository.deleteById(id);
            return ResponseEntity.ok("Deleted."); // A success message
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

