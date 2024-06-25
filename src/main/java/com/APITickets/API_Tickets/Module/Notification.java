package com.APITickets.API_Tickets.Module;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Notification {

        private String to;
        private String subject;
        private String text;
    }
