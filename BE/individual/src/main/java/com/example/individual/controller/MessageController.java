package com.example.individual.controller;

import com.example.individual.model.Message;
import com.example.individual.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * REST controller for managing messages.
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    /**
     * Get all messages.
     *
     * @return List of all messages.
     */
    @GetMapping
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    /**
     * Get messages sent by a specific sender.
     *
     * @param senderUsername The username of the sender.
     * @return List of messages sent by the sender.
     */
    @GetMapping("/bySenderUsername")
    public List<Message> getMessagesBySenderUsername(@RequestParam("senderUsername") String senderUsername) {
        return messageRepository.findBySenderUsername(senderUsername);
    }

    /**
     * Get messages received by a specific receiver.
     *
     * @param receiverUsername The username of the receiver.
     * @return List of messages received by the receiver.
     */
    @GetMapping("/byReceiverUsername")
    public List<Message> getMessagesByReceiverUsername(@RequestParam("receiverUsername") String receiverUsername) {
        return messageRepository.findByReceiverUsername(receiverUsername);
    }

    /**
     * Get messages exchanged between two users.
     *
     * @param username1 The username of the first user.
     * @param username2 The username of the second user.
     * @return List of messages exchanged between the two users.
     */
    @GetMapping("/betweenUsers")
    public List<Message> getMessagesBetweenUsers(
            @RequestParam("username1") String username1,
            @RequestParam("username2") String username2) {
        return messageRepository.findMessagesBetweenUsers(username1, username2);
    }

    /**
     * Get a message by its unique ID.
     *
     * @param id The unique ID of the message.
     * @return ResponseEntity containing the message if found, or a not-found response.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("id") int id) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        return optionalMessage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Create a new message.
     *
     * @param message The Message object to be created.
     * @return ResponseEntity containing the created Message object.
     */
    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message createdMessage = messageRepository.save(message);
        return ResponseEntity.ok(createdMessage);
    }

    /**
     * Update an existing message by ID.
     *
     * @param id             The unique ID of the message to be updated.
     * @param updatedMessage The updated Message object.
     * @return ResponseEntity containing the updated Message object if found, or a not-found response.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable("id") int id, @RequestBody Message updatedMessage) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();


            if (updatedMessage.getSendTime() != null) {
                message.setSendTime(updatedMessage.getSendTime());
            }
            if (updatedMessage.getText() != null) {
                message.setText(updatedMessage.getText());
            }
            if (updatedMessage.getSenderUsername() != null) {
                message.setSenderUsername(updatedMessage.getSenderUsername());
            }
            if (updatedMessage.getReceiverUsername() != null) {
                message.setReceiverUsername(updatedMessage.getReceiverUsername());
            }

            Message updated = messageRepository.save(message);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Delete a message by its unique ID.
     *
     * @param id The unique ID of the message to be deleted.
     * @return ResponseEntity containing a success message if the message is deleted, or a not-found response.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable("id") int id) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        if (optionalMessage.isPresent()) {
            messageRepository.deleteById(id);
            return ResponseEntity.ok("Deleted."); // A success message
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
