package com.APITickets.API_Tickets.Controller;

import com.APITickets.API_Tickets.Module.Notification;
import com.APITickets.API_Tickets.Services.NotifService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notif")
@AllArgsConstructor
@Tag(name ="Notification", description = "La notification fait référence à un document écrit qui est destiné" +
        " à informer une personne d'une règlementation, ou d'une information légale importante.")

public class NotifController {

    private NotifService emailService;

    @Operation(description = "Ce point d'entré permet d'envoyer une notification")
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

