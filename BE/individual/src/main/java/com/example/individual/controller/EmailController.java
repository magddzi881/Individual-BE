package com.example.individual.controller;

import com.example.individual.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendChangedPassword")
    public ResponseEntity<String> sendChangedPassword(@RequestBody Map<String,String> data) {
        try {

            String title = "Individual: Hello "+data.get("name")+" "+data.get("surname") +"! [Warning]";
            String template = "Hello "+data.get("name")+" "+data.get("surname") +",\n"
                    + "a password change has been detected on your account associated with username:"+"\n\n"
                    + data.get("username")+"\n\n"
                    + "If you have not changed your password, please contact our administration.\n"
                    + "We hope you're having a great day!\n\n"
                    + "Best regards,\n"
                    + "The Individual Team";


            emailService.sendEmail(data.get("address"), title, template, "Individual@team.com");

            return ResponseEntity.ok("Email sent successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email: " + e.getMessage());
        }
    }

    @PostMapping("/sendNewUser")
    public ResponseEntity<String> sendNewUser(@RequestBody Map<String,String> data) {
        try {

            String title = "Individual: Hello "+data.get("name")+" "+data.get("surname") +"!";
            String template = "Hello "+data.get("name")+" "+data.get("surname") +",\n"
                    + "your new account has been created, your username:"+"\n\n"
                    + data.get("username")+"\n\n"
                    + "You can log in now, thank you for joining our community.\n"
                    + "We hope you're having a great day!\n\n"
                    + "Best regards,\n"
                    + "The Individual Team";


            emailService.sendEmail(data.get("address"), title, template, "Individual@team.com");

            return ResponseEntity.ok("Email sent successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email: " + e.getMessage());
        }
    }
}
