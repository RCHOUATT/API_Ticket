package com.APITickets.API_Tickets.Controller;

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
    public String sendEmail(@RequestParam String to){
        String subject = "New Product Launch: Smart Wearable Fitness Tracker";
        String content = """
        <!DOCTYPE html>
        <html>
        <head>
        <style>
        .email-body { font-family: 'Arial', sans-serif; max-width: 600px; margin: auto; }
        .header { background-color: #f3f3f3; padding: 20px; }
        .content { padding: 20px; }
        .cta-button { display: block; width: 200px; margin: 20px auto; padding: 10px; background-color: #007bff; color: white; text-align: center; text-decoration: none; }
        </style>
        </head>
        <body>
        <div class="email-body">
        <div class="header">New Product Launch: Smart Wearable Fitness Tracker</div>
        <div class="content">Discover the latest in wearable fitness technology and take your health to the next level with our new Smart Fitness Tracker. Explore its features now!</div>
        <a href="https://www.example.com" class="cta-button">Learn More</a>
        </div>
        </body>
        </html>
        """;

        try {
            emailService.sendEmail(to, subject, content);
            return "Email sent successfully";
        } catch (MessagingException e) {
            return "Error sending email: " + e.getMessage();
        }
    }
    }

