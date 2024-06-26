package com.APITickets.API_Tickets.Controller;

import com.APITickets.API_Tickets.Module.Notification;
import com.APITickets.API_Tickets.Services.NotifService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notif")
@AllArgsConstructor
public class NotifController {

    private NotifService emailService;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody Notification notification){
        String subject = "New Product Launch: Smart Wearable Fitness Tracker";

        try {
            emailService.sendEmail(notification);
            return "Email sent successfully";
        } catch (MessagingException e) {
            return "Error sending email: " + e.getMessage();
        }
    }
    }

