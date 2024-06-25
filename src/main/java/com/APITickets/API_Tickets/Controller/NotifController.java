package com.APITickets.API_Tickets.Controller;

import com.APITickets.API_Tickets.Module.Notification;
import com.APITickets.API_Tickets.Services.NotifService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notif")
@AllArgsConstructor
public class NotifController {

    private NotifService emailService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody Notification emailRequest) {
        emailService.sendSimpleMessage(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
        return "Email sent successfully!";
    }
}

